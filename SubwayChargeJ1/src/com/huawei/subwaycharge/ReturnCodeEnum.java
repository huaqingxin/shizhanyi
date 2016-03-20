package com.huawei.subwaycharge;

public enum ReturnCodeEnum
{
  I00, I10, I11, I12, I13, I20, I22 , I30, E01, E02, E21,E22;

  private static final String[] ERR_CODE_STR;

  static
  {
    ERR_CODE_STR = new String[] { 
      "I00:��ӭʹ�õ����շ�ϵͳ", 
      "I10:�۷�ʧ��(��Ч·��)", 
      "I11:�۷ѳɹ�", 
      "I12:�۷ѳɹ�(������)", 
      "I13:�۷�ʧ��(����)", 
      "I20:��ѯ�ɹ�", 
      "I22:Ʊ��ע���ɹ�", 
      "I30:��ѯ���ѳɹ�", 
      "E01:�Ƿ�����", 
      "E02:��������(ʱ���ϵ����)", 
      "E21:��ѯʧ��(����Ӧ��¼)",
      "E22:����ʧ�ܣ���Ʊ����ע��"};
  }

  public String toString()
  {
    return ERR_CODE_STR[ordinal()];
  }
}