package io.rackshift.metal.sdk.model;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class Ip implements Serializable {
    @ApiModelProperty("")
    private String id;

    @ApiModelProperty("IP地址")
    private String ip;

    @ApiModelProperty("子网掩码")
    private String mask;

    @ApiModelProperty("网关")
    private String gateway;

    @ApiModelProperty("DNS1")
    private String dns1;

    @ApiModelProperty("DNS2")
    private String dns2;

    @ApiModelProperty("区域")
    private String region;

    @ApiModelProperty("网络ID")
    private String networkId;

    @ApiModelProperty("资源类型")
    private String resourceType;

    @ApiModelProperty("资源ID")
    private String resourceId;

    @ApiModelProperty("订单项ID")
    private String orderItemId;

    @ApiModelProperty("状态")
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pm_ip
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.id
     *
     * @return the value of pm_ip.id
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.id
     *
     * @param id the value for pm_ip.id
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.ip
     *
     * @return the value of pm_ip.ip
     * @mbg.generated
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.ip
     *
     * @param ip the value for pm_ip.ip
     * @mbg.generated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.mask
     *
     * @return the value of pm_ip.mask
     * @mbg.generated
     */
    public String getMask() {
        return mask;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.mask
     *
     * @param mask the value for pm_ip.mask
     * @mbg.generated
     */
    public void setMask(String mask) {
        this.mask = mask == null ? null : mask.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.gateway
     *
     * @return the value of pm_ip.gateway
     * @mbg.generated
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.gateway
     *
     * @param gateway the value for pm_ip.gateway
     * @mbg.generated
     */
    public void setGateway(String gateway) {
        this.gateway = gateway == null ? null : gateway.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.dns1
     *
     * @return the value of pm_ip.dns1
     * @mbg.generated
     */
    public String getDns1() {
        return dns1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.dns1
     *
     * @param dns1 the value for pm_ip.dns1
     * @mbg.generated
     */
    public void setDns1(String dns1) {
        this.dns1 = dns1 == null ? null : dns1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.dns2
     *
     * @return the value of pm_ip.dns2
     * @mbg.generated
     */
    public String getDns2() {
        return dns2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.dns2
     *
     * @param dns2 the value for pm_ip.dns2
     * @mbg.generated
     */
    public void setDns2(String dns2) {
        this.dns2 = dns2 == null ? null : dns2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.region
     *
     * @return the value of pm_ip.region
     * @mbg.generated
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.region
     *
     * @param region the value for pm_ip.region
     * @mbg.generated
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.network_id
     *
     * @return the value of pm_ip.network_id
     * @mbg.generated
     */
    public String getNetworkId() {
        return networkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.network_id
     *
     * @param networkId the value for pm_ip.network_id
     * @mbg.generated
     */
    public void setNetworkId(String networkId) {
        this.networkId = networkId == null ? null : networkId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.resource_type
     *
     * @return the value of pm_ip.resource_type
     * @mbg.generated
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.resource_type
     *
     * @param resourceType the value for pm_ip.resource_type
     * @mbg.generated
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.resource_id
     *
     * @return the value of pm_ip.resource_id
     * @mbg.generated
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.resource_id
     *
     * @param resourceId the value for pm_ip.resource_id
     * @mbg.generated
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.order_item_id
     *
     * @return the value of pm_ip.order_item_id
     * @mbg.generated
     */
    public String getOrderItemId() {
        return orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.order_item_id
     *
     * @param orderItemId the value for pm_ip.order_item_id
     * @mbg.generated
     */
    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId == null ? null : orderItemId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pm_ip.status
     *
     * @return the value of pm_ip.status
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pm_ip.status
     *
     * @param status the value for pm_ip.status
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}