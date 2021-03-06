<template>
    <div class="container">

        <div class="machine-title">
            <i class="el-icon-s-home">{{$t('SystemParameter')}}</i>
            <div class="el-button-group batch-button">
                <button type="button" class="el-button el-button--primary"><i
                        class="el-icon-delete" @click="delAllSelection"></i>{{$t('batch_del')}}
                </button>
                <button type="button" class="el-button el-button--primary" @click="handleEdit({}, 'add')"><i
                        class="el-icon-document-add"></i>{{$t('add')}}
                </button>
            </div>
        </div>

        <el-table
                :data="tableData"
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                style="width: 100%"
                @selection-change="handleSelectionChange"
        >
            <el-table-column type="selection" align="center"></el-table-column>
            <el-table-column :prop="c.prop" :label="c.label" align="center"
                             v-for="c in columns" sortable></el-table-column>

            <el-table-column prop="" :label="$t('opt')" align="center">
                <template slot-scope="scope">
                    <el-button
                            type="button"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.row, 'edit')"
                    >{{$t('edit')}}
                    </el-button>

                    <el-button
                            type="button"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleEdit(scope.row, 'del')"
                    >{{$t('del')}}
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <div class="pagination">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handlePageChange"
                    :current-page="query.pageIndex"
                    :page-sizes="[10, 20, 50, 100]"
                    :page-size="10"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="pageTotal">
            </el-pagination>
        </div>

        <el-drawer
                :title="editType == 'edit' ? $t('edit_system_parameter') : $t('add_system_parameter')"
                :visible.sync="editDialogVisible"
                direction="rtl"
                :before-close="handleClose">
            <div class="demo-drawer__content">
                <el-form :model="editObj">
                    <el-form-item :label="$t('param_key')">
                        <el-input v-model="editObj.paramKey" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item :label="$t('param_value')">
                        <el-input v-model="editObj.paramValue" autocomplete="off"
                                  :placeholder="$t('pls_input_param_value')"></el-input>
                    </el-form-item>
                </el-form>
                <div class="demo-drawer__footer">
                    <el-button @click="editDialogVisible = false">{{$t('cancel')}}</el-button>
                    <el-button type="primary" @click="confirmEdit" :loading="loading">{{ loading ? $t('submitting') +
                        '...' : $t('confirm')
                        }}
                    </el-button>
                </div>
            </div>
        </el-drawer>

    </div>
</template>

<script>

    import HttpUtil from "../../common/utils/HttpUtil"

    let _ = require('lodash');
    export default {
        data() {
            return {
                query: {
                    name: '',
                    pageIndex: 1,
                    pageSize: 10
                },
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                pageTotal: 0,
                form: {},
                idx: -1,
                id: -1,
                loading: false,
                columns: [
                    {
                        label: this.$t('param_key'),
                        prop: "paramKey",
                        sort: true
                    },
                    {
                        label: this.$t('param_value'),
                        prop: "paramValue"
                    },
                ],
                editDialogVisible: false,
                editType: 'edit',
                editObj: {
                    name: null,
                    description: null,
                    type: null
                },
                allOs: [],
                allOsVersion: []
            };
        },
        mounted() {
            this.getData();
            this.getAllOsAndVersion();
        },
        methods: {
            // 获取 easy-mock 的模拟数据
            getData() {
                HttpUtil.post("/system_parameter/list/" + this.query.pageIndex + "/" + this.query.pageSize, {}, (res) => {
                    this.tableData = res.data.listObject;
                    this.pageTotal = res.data.itemCount;
                });

            },
            getAllOsAndVersion() {
                HttpUtil.get("/rackhd/allOsAndVersion", {}, (res) => {
                    this.allOs = res.data;
                });
            },
            handleSizeChange(val) {
                this.query.pageSize = val;
            },
            changeOsVersion() {
                this.allOsVersion = _.find(this.allOs, {"id": this.editObj.os}).versions;
            },
            handleClose() {
                this.editDialogVisible = false;
            },
            add() {
                this.editDialogVisible = true;
                this.editType = 'add';
            },
            confirmEdit() {
                if (this.editType == 'edit') {
                    HttpUtil.post("/system_parameter/update", this.editObj, (res) => {
                        this.editDialogVisible = false;
                        this.$message.success('编辑成功');
                        this.getData();
                    })
                } else {
                    HttpUtil.post("/system_parameter/add", this.editObj, (res) => {
                        this.editDialogVisible = false;
                        this.$message.success('新增成功');
                        this.getData();
                    })
                }
            },
            // 多选操作
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            delAllSelection() {
                const length = this.multipleSelection.length;
                let str = '';
                this.delList = this.delList.concat(this.multipleSelection);
                for (let i = 0; i < length; i++) {
                    str += this.multipleSelection[i].name + ' ';
                }
                let ids = _.map(this.delList, (item) => item.paramKey);
                HttpUtil.post("/system_parameter/del", ids, (res) => {
                    this.$message.success(`删除成功！删除了${str}！`);
                    this.getData();
                });
                this.multipleSelection = [];
            },
            // 编辑操作
            handleEdit(row, type) {
                if (type == 'edit') {
                    this.editDialogVisible = true;
                    this.editType = type;
                    this.editObj = JSON.parse(JSON.stringify(row));
                } else if (type == 'del') {
                    this.$confirm('确定要删除吗？', '提示', {
                        type: 'warning'
                    }).then(() => {
                        HttpUtil.get("/system_parameter/del/" + row.paramKey, {}, (res) => {
                            this.getData();
                            this.$message.success('删除成功');
                        });
                    })
                } else {
                    this.editDialogVisible = true;
                    this.editType = type;
                    this.editObj = {};
                }
            },
            // 分页导航
            handlePageChange(val) {
                this.$set(this.query, 'pageIndex', val);
                this.getData();
            }
        }
    }
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .table {
        width: 100%;
        font-size: 14px;
    }

    .mr10 {
        margin-right: 10px;
    }

</style>