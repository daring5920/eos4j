package io.eblock.eos4j.api.vo.transaction.history;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.eblock.eos4j.api.vo.transaction.action.ActionTraceBean;

import java.util.List;

public class Transaction {

    private String id;

    private Object trx;

    private String blockTime;

    private Integer blockNum;

    private Integer lastIrreversibleBlock;

    private List<ActionTraceBean> traces = null;

    private String status;

    private String cpuUsageUs;

    private String netUsageWords;

    public String getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(String id) {
        this.id = id;
    }

    public Object getTrx() {
        return trx;
    }

    @SerializedName("trx")
    public void setTrx(Object trx) {
        this.trx = trx;
    }

    public String getBlockTime() {
        return blockTime;
    }

    @SerializedName("block_time")
    public void setBlockTime(String blockTime) {
        this.blockTime = blockTime;
    }

    public Integer getBlockNum() {
        return blockNum;
    }

    @SerializedName("block_num")
    public void setBlockNum(Integer blockNum) {
        this.blockNum = blockNum;
    }

    public Integer getLastIrreversibleBlock() {
        return lastIrreversibleBlock;
    }

    @SerializedName("last_irreversible_block")
    public void setLastIrreversibleBlock(Integer lastIrreversibleBlock) {
        this.lastIrreversibleBlock = lastIrreversibleBlock;
    }

    public List<ActionTraceBean> getTraces() {
        return traces;
    }

    @SerializedName("traces")
    public void setTraces(List<ActionTraceBean> traces) {
        this.traces = traces;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpuUsageUs() {
        return cpuUsageUs;
    }

    @SerializedName("cpu_usage_us")
    public void setCpuUsageUs(String cpuUsageUs) {
        this.cpuUsageUs = cpuUsageUs;
    }

    public String getNetUsageWords() {
        return netUsageWords;
    }

    @SerializedName("net_usage_words")
    public void setNetUsageWords(String netUsageWords) {
        this.netUsageWords = netUsageWords;
    }
}
