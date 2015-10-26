package constant;

import java.io.Serializable;

/**
 * 包装类型（纸箱、木箱、快递袋、其他）
 */
public enum PackageType implements Serializable{
	CARTON, WOODEN, COURIER_BAG, OTHER
}
