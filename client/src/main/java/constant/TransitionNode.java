package constant;

import java.io.Serializable;

/**
 * 货物所在站点
 * （寄件人营业厅、寄件人中转中心、收件人营业厅、收件人中转中心，收件人手中）
 */
public enum TransitionNode implements Serializable{
	BUSINESS_HALL, TRANSI_CENTER
}
