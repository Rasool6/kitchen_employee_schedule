package com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("t_id")
    @Expose
    private String tId;
    @SerializedName("t_name")
    @Expose
    private String tName;
    @SerializedName("t_day")
    @Expose
    private String tDay;
    @SerializedName("e_id")
    @Expose
    private String eId;
    @SerializedName("d_task_status")
    @Expose
    private String dTaskStatus;
    @SerializedName("date")
    @Expose
    private String date;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param date
     * @param eId
     * @param tName
     * @param dTaskStatus
     * @param tDay
     * @param tId
     */
    public Datum(String tId, String tName, String tDay, String eId, String dTaskStatus, String date) {
        super();
        this.tId = tId;
        this.tName = tName;
        this.tDay = tDay;
        this.eId = eId;
        this.dTaskStatus = dTaskStatus;
        this.date = date;
    }

    public String getTId() {
        return tId;
    }

    public void setTId(String tId) {
        this.tId = tId;
    }

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName;
    }

    public String getTDay() {
        return tDay;
    }

    public void setTDay(String tDay) {
        this.tDay = tDay;
    }

    public String getEId() {
        return eId;
    }

    public void setEId(String eId) {
        this.eId = eId;
    }

    public String getDTaskStatus() {
        return dTaskStatus;
    }

    public void setDTaskStatus(String dTaskStatus) {
        this.dTaskStatus = dTaskStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
