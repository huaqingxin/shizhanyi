package com.huawei.subwaycharge;

import com.huawei.subwaycharge.ChargeLogInfo;
import com.huawei.subwaycharge.OpResult;

import java.util.ArrayList;
import java.util.List;

public class ReturnCodeRst extends OpResult
{
  private ReturnCodeEnum errCode = null;
  private static final int MAX_LOG_NUM = 10;
  private int cardID = 0;
  private int moneyLeft = 0;
  private List<ChargeLogInfo> chargedList = new ArrayList();
  private CardTypeEnum cate;

  public ReturnCodeRst(ReturnCodeEnum errCode)
  {
    this.errCode = errCode;
  }

  public ReturnCodeRst(ReturnCodeEnum returnCode, int cardNo, int moneyLeft)
  {
    this.errCode = returnCode;
    this.cardID = cardNo;
    this.moneyLeft = moneyLeft;
  }

  public ReturnCodeRst(ReturnCodeEnum returnCode, ChargeLogInfo[] logs)
  {
    this.errCode = returnCode;
    this.chargedList.clear();

    for (int i = 0; (i < 10) && (i < logs.length); ++i)
    {
      this.chargedList.add(logs[i]);
    }
  }

  public ReturnCodeRst(ReturnCodeEnum returnCode, ChargeLogInfo[] logs,CardTypeEnum cate)
  {
    this.errCode = returnCode;
    this.chargedList.clear();
    this.cate=cate;

    for (int i = 0; (i < 10) && (i < logs.length); ++i)
    {
      this.chargedList.add(logs[i]);
    }
  }
  
  
  
  public String toString()
  {
    StringBuffer sb;
    if (this.errCode == null)
    {
      return "";
    }

    if (ReturnCodeEnum.I00 == this.errCode)
    {
      return "I00:��ӭʹ�õ����շ�ϵͳ";
    }

    if (ReturnCodeEnum.E01 == this.errCode)
    {
      return "E01:�Ƿ�����";
    }
    if (ReturnCodeEnum.E02 == this.errCode)
    {
      return "E02:��������(ʱ���ϵ����)";
    }
    if (ReturnCodeEnum.E21 == this.errCode)
    {
      return "E21:��ѯʧ��(����Ӧ��¼)";
    }
    if (ReturnCodeEnum.E22 == this.errCode)
    {
      return "E22:����ʧ�ܣ���Ʊ����ע��";
    }
    if (ReturnCodeEnum.I10 == this.errCode)
    {
      sb = new StringBuffer();
      sb.append("I10:�۷�ʧ��(��Ч·��)\r\n");
      sb.append("<����=").append(this.cardID).append(">");
      sb.append("<���=").append(this.moneyLeft).append(">");
      return sb.toString();
    }
    if (ReturnCodeEnum.I11 == this.errCode)
    {
      sb = new StringBuffer();
      sb.append("I11:�۷ѳɹ�\r\n");
      sb.append("<����=").append(this.cardID).append(">");
      sb.append("<���=").append(this.moneyLeft).append(">");
      return sb.toString();
    }
    if (ReturnCodeEnum.I12 == this.errCode)
    {
      sb = new StringBuffer();
      sb.append("I12:�۷ѳɹ�(������)\r\n");
      sb.append("<����=").append(this.cardID).append(">");
      sb.append("<���=").append(this.moneyLeft).append(">");
      return sb.toString();
    }
    if (ReturnCodeEnum.I22 == this.errCode)
    {
      sb = new StringBuffer();
      sb.append("I22:Ʊ��ע���ɹ�\r\n");
      sb.append("<����=").append(this.cardID).append(">");
      sb.append("<���=").append(this.moneyLeft).append(">");
      return sb.toString();
    }
    if (ReturnCodeEnum.I13 == this.errCode)
    {
      sb = new StringBuffer();
      sb.append("I13:�۷�ʧ��(����)\r\n");
      sb.append("<����=").append(this.cardID).append(">");
      sb.append("<���=").append(this.moneyLeft).append(">");
      return sb.toString();
    }
    if (ReturnCodeEnum.I20 == this.errCode)
    {
      sb = new StringBuffer();
      String rstLogStr = "";
      sb.append("I20:��ѯ�ɹ�\r\n");
      if (this.chargedList == null)
      {
        rstLogStr = "";
      }
      else
      {
        rstLogStr = getLogInfoStr();
      }
      sb.append(rstLogStr);
      return sb.toString();
    }
    
    if (ReturnCodeEnum.I30 == this.errCode)
    {
      sb = new StringBuffer();
      String rstLogStr = "";
      sb.append("I30:��ѯ���ѳɹ�\r\n");
      if (this.chargedList == null)
      {
        rstLogStr = "";
      }
      else
      {
        rstLogStr = getLogInfoStr2();
      }
      sb.append(rstLogStr);
      return sb.toString();
    }
    return "";
  }

  private String getLogInfoStr()
  {
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < this.chargedList.size(); ++i)
    {
      ChargeLogInfo cl = (ChargeLogInfo)this.chargedList.get(i);
      sb.append("<").append(cl.getCardNo()).append(">");
      sb.append("<").append(String.format("%02d", new Object[] { Integer.valueOf(cl.getInHour()) })).append(":").append(String.format("%02d", new Object[] { Integer.valueOf(cl.getInMinute()) })).append(">");
      sb.append("<").append(cl.getInStation()).append(">");
      sb.append("<").append(String.format("%02d", new Object[] { Integer.valueOf(cl.getOutHour()) })).append(":").append(String.format("%02d", new Object[] { Integer.valueOf(cl.getOutMinute()) })).append(">");
      sb.append("<").append(cl.getOutStation()).append(">");
      sb.append("<").append(cl.getChargeCount()).append(">");
      if (cl.isCharged())
      {
        sb.append("<").append("�ɹ�").append(">");
      }
      else
      {
        sb.append("<").append("ʧ��").append(">");
      }
      sb.append("\r\n");
    }
    return sb.toString();
  }
  
  
  
  
  private String getLogInfoStr2()
  {
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < this.chargedList.size(); ++i)
    {
      ChargeLogInfo cl = (ChargeLogInfo)this.chargedList.get(i);
      sb.append("<").append("��ʷ���Ѽ�¼").append("> ");
      sb.append("���ţ�").append(cl.getCardNo()).append(" ");
      sb.append("�����");
      if(cate==CardTypeEnum.A)
    	  sb.append("����Ʊ ");
      else if(cate==CardTypeEnum.B)
    	  sb.append("���꿨 ");
      else
    	  sb.append("��ͨ�� ");
      sb.append("��վʱ�䣺").append(String.format("%02d", new Object[] { Integer.valueOf(cl.getInHour()) })).append(":").append(String.format("%02d", new Object[] { Integer.valueOf(cl.getInMinute()) })).append(" ");
      sb.append("��վ���ƣ�").append(cl.getInStation()).append(" ");
      sb.append("��վʱ�䣺").append(String.format("%02d", new Object[] { Integer.valueOf(cl.getOutHour()) })).append(":").append(String.format("%02d", new Object[] { Integer.valueOf(cl.getOutMinute()) })).append(" ");
      sb.append("��վ���ƣ�").append(cl.getOutStation()).append(" ");
      sb.append("���ã�").append(cl.getChargeCount());
      sb.append("\r\n");
    }
    return sb.toString();
  }
  
  
  
  
  
  
  
}