# RackShift

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2d7d7a82829e4e4e80c0f2a9aa2397ca)](https://app.codacy.com/manual/rackshift/rackshift?utm_source=github.com&utm_medium=referral&utm_content=rackshift/rackshift&utm_campaign=Badge_Grade_Dashboard)
| Developer Wanted                                                                                             |
| ------------------------------------------------------------------------------------------------------------ |
| 我们正在寻找开发者，欢迎加入我们共同打造更好用、更强大的 RackShift。联系我们： [dahai.zhang@fit2cloud.com](mailto:dahai.zhang@fit2cloud.com) |

RackShift 是完全开源的裸金属服务器装机管理平台，功能覆盖裸金属服务器的发现、带外管理、系统安装（包含 RAID 配置）等。RackShift 基于任务工作流，提供可视化的 WebUI，支持市面上主流 X86 物理服务器品牌，如浪潮、戴尔、华为、联想、惠普等。

![runoob](https://f2c-south.oss-cn-shenzhen.aliyuncs.com/RackHD-dont-del/RackShift/rs-main.png)

## 解决的问题
- 各种网络环境下裸金属服务器的自动、手动发现；
- 裸金属服务器的带外控制管理，包括开关机、重启、配置 PXE 等；
- 裸金属服务器批量装机、RAID配置和固件更新。

## 技术优势
  
- 全生命周期: 能够覆盖裸金属从发现、配置、装机、重置的全生命周期管理；
- 自动化：基于 PXE 或者带外协议实现远程自动化，解放机房运维人员；
- 易操作: 浏览器可视化操作界面，易于操作和管理。

## 功能列表

<table> 
   <tbody> 
    <tr> 
     <td>自动发现</td> 
     <td>支持主流品牌裸金属服务器，通过带外控制卡，IPMI 协议，PXE 网络自动发现</td> 
    </tr> 
    <tr> 
     <td rowspan="2">设备纳管</td> 
     <td>收集硬件设备信息， CPU， 内存， RAID 控制器， 磁盘， 网卡等，自动检测硬件变更</td> 
    </tr> 
     <tr>
       <td>支持纳管设备带外远程开机、关机、重启等电源操作</td>
     </tr>
    <tr> 
     <td rowspan="2">无人值守安装</td> 
     <td>支持安装 Ubuntu， CentOS, Windows 和 RHEL 等操作系统，部署完毕只需要重启一次，整个部署时间不超过8分钟</td> 
    </tr> 
    <tr> 
     <td>支持用户配置 RAID 等存储配置</td> 
    </tr> 
    <tr> 
     <td>跨网域支持</td> 
     <td>支持配置代理节点，实现复杂网络下统一发现、安装、运维</td>
    </tr>
    <tr> 
     <td rowspan="2">任务流支持</td> 
     <td>支持针对品牌配置不同任务流，实现重置、安装、配置流水线</td>
    </tr>
    <tr> 
     <td>支持批量执行任务流，统一实时查看任务详情</td>
    </tr>
    <tr> 
     <td>被集成能力</td> 
     <td>支持完整裸金属生命周期管理 Restful API，快速集成与被集成</td>
    </tr>
   </tbody> 
  </table>

详细的版本规划请参考 [版本路线图](https://github.com/rackshift/rackshift/blob/master/ROADMAP.md)  

如果您想进一步了解目前的开发进度请查看
[开发进度](https://trello.com/b/rEE3zYaF/rackshift)  

## 技术架构
![runoob](https://f2c-south.oss-cn-shenzhen.aliyuncs.com/RackHD-dont-del/RackShift/rackshift-struc.jpg)

组件说明：

- RackShift-Web： RackShift 前端界面，基于 VUE2.6.11 开发的单页应用；
- RackShift-Server： RackShift 后台服务，基于 SpringBoot 框架，对底层管理裸金属服务器能力进行更高层的抽象；
- RackShift-Proxy： 用于控制注入镜像下发，DHCP 配置，远程 KVM 等等；
- RackHD： EMC 开源的裸金属管理软件，现已停止维护，RackShift 项目对其进行了大量优化和集成；
- MySQL：RackShift-Server 主要运行数据的存储区；
- Mongo：RackHD 与 RackShift-Server 的运行数据存储区；
- RabbitMQ: 各组件之间通信中间件；
- DockerEngine：各组件的容器运行时。

## 组件调用关系
![runoob](https://f2c-south.oss-cn-shenzhen.aliyuncs.com/RackHD-dont-del/RackShift/rs-call2.jpg)

## 技术栈

- 前端: [Vue.js](https://vuejs.org/)
- 后端: [Spring Boot](https://www.tutorialspoint.com/spring_boot/spring_boot_introduction.htm)s
- 数据库: [MySQL](https://www.mysql.com/)

## 快速开始

仅需两步快速安装 RackShift：

 * 准备一台不小于 8G 内存，50G 硬盘且可以访问互联网的 64位 Linux 主机；
 * 以 root 用户执行如下命令一键安装 RackShift。
```sh
curl -sSL https://github.com/rackshift/rackshift/releases/latest/download/quick_start.sh | sh
```

## 体验环境
- http://rs.dahaia123.top:8080/ 账号密码 admin / 123
## 帮助文档
- [帮助文档](https://rackshift.github.io/rackshift-docs-static/)

## 微信群

<img src="https://f2c-south.oss-cn-shenzhen.aliyuncs.com/RackHD-dont-del/RackShift/rs-12-10.jpg" width="300" height="300" align="middle" />

## QQ 群
- 693376431

## 致谢

-  [RackHD](https://rackhd.github.io/)：RackShift 集成和参考了 RackHD 提供的裸金属服务器管理能力和思路；
-  [MAAS](https://maas.io/)：RackShift 参考了 MAAS 提供的裸金属生命周期纳管思路；
-  [Digital Rebar](https://rackn.com/rebar/)：RackShift 参考了 Digital Rebar 提供的操作方式和 UI 参考；
-  [Element](https://element.eleme.cn/#/)：RackShift 使用 Element 提供的优秀前端组件库。
