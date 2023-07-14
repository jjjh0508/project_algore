package com.algore.application.kitchenguide.dto;

public class TrimProcedureDTO {

    private int tpStepNum; //단계번호
    private int trimNum; //손질번호
    private String tpFileName; //파일명
    private String tpDetail; //내용
    private String tpPath; //저장경로

    public TrimProcedureDTO() {
    }

    public TrimProcedureDTO(int tpStepNum, int trimNum, String tpFileName, String tpDetail, String tpPath) {
        this.tpStepNum = tpStepNum;
        this.trimNum = trimNum;
        this.tpFileName = tpFileName;
        this.tpDetail = tpDetail;
        this.tpPath = tpPath;
    }

    public int getTpStepNum() {
        return tpStepNum;
    }

    public void setTpStepNum(int tpStepNum) {
        this.tpStepNum = tpStepNum;
    }

    public int getTrimNum() {
        return trimNum;
    }

    public void setTrimNum(int trimNum) {
        this.trimNum = trimNum;
    }

    public String getTpFileName() {
        return tpFileName;
    }

    public void setTpFileName(String tpFileName) {
        this.tpFileName = tpFileName;
    }

    public String getTpDetail() {
        return tpDetail;
    }

    public void setTpDetail(String tpDetail) {
        this.tpDetail = tpDetail;
    }

    public String getTpPath() {
        return tpPath;
    }

    public void setTpPath(String tpPath) {
        this.tpPath = tpPath;
    }

    @Override
    public String toString() {
        return "TrimProcedureDTO{" +
                "tpStepNum=" + tpStepNum +
                ", trimNum=" + trimNum +
                ", tpFileName='" + tpFileName + '\'' +
                ", tpDetail='" + tpDetail + '\'' +
                ", tpPath='" + tpPath + '\'' +
                '}';
    }

}
