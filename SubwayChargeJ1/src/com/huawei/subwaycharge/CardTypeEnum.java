package com.huawei.subwaycharge;

/**
 * <p>Title: ���������޸�</p>
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
public enum CardTypeEnum {
            A, /* ����Ʊ */
            B, /* ���꿨 */
            C; /* ��ͨ�� */

    private static final String[] CARD_TYPE_STR;

    public String toString() {
        return CARD_TYPE_STR[this.ordinal()];
    }

    static {
        CARD_TYPE_STR = new String[] {"����Ʊ", "���꿨", "��ͨ��"};
    }
}
