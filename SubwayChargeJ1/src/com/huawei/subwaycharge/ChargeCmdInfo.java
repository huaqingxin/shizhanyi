package com.huawei.subwaycharge;

/**
 * <p>Title: �������Ը����Լ��������ڱ��������ӷ������������޸����з��������</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class ChargeCmdInfo {

    /* ����۷Ѳ���������� �ṹ */
    private int cardNo; /* ���� */
    private CardTypeEnum cardType; /* ������ */
    private int cardMoney; /* ���ڵ�ǰ��� */
    private int inHour; /* ��վʱ��:�ӵ�(��Χ: 0 ~ 23) */
    private int inMinute; /* ��վʱ��:����(��Χ: 0 ~ 59) */
    private String inStation; /* ��վվ������ */

    private int outHour; /* ��վʱ��:�ӵ�(��Χ: 0 ~ 23) */
    private int outMinute; /* ��վʱ��:����(��Χ: 0 ~ 59) */
    private String outStation; /* ��վվ������ */

    public ChargeCmdInfo() {

    }

    public ChargeCmdInfo(int cardNo, CardTypeEnum cardType, int cardMoney,
                         int inHour, int inMinute, String inStation, int outHour,
                         int outMinute, String outStation) {

        this.cardNo = cardNo;
        this.cardType = cardType;
        this.cardMoney = cardMoney;
        this.inHour = inHour;
        this.inMinute = inMinute;
        this.inStation = inStation;
        this.outHour = outHour;
        this.outMinute = outMinute;
        this.outStation = outStation;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public CardTypeEnum getCardType() {
        return cardType;
    }

    public void setCardType(CardTypeEnum cardType) {
        this.cardType = cardType;
    }

    public int getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(int cardMoney) {
        this.cardMoney = cardMoney;
    }

    public int getInHour() {
        return inHour;
    }

    public void setInHour(int inHour) {
        this.inHour = inHour;
    }

    public int getInMinute() {
        return inMinute;
    }

    public void setInMinute(int inMinute) {
        this.inMinute = inMinute;
    }

    public String getInStation() {
        return inStation;
    }

    public void setInStation(String inStation) {
        this.inStation = inStation;
    }

    public int getOutHour() {
        return outHour;
    }

    public void setOutHour(int outHour) {
        this.outHour = outHour;
    }

    public int getOutMinute() {
        return outMinute;
    }

    public void setOutMinute(int outMinute) {
        this.outMinute = outMinute;
    }

    public String getOutStation() {
        return outStation;
    }

    public void setOutStation(String outStation) {
        this.outStation = outStation;
    }
}
