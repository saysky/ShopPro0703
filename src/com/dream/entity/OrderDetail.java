package com.dream.entity;

public class OrderDetail {


	private int id;
	private int o_orderid;
	private int goodsid;
	private String goodsname;
	private double goodsprice;
	private String goods_description;
	private int goodsnum;
	private String goodspic;
	private double goods_total_price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getO_orderid() {
		return o_orderid;
	}

	public void setO_orderid(int o_orderid) {
		this.o_orderid = o_orderid;
	}

	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public double getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(double goodsprice) {
		this.goodsprice = goodsprice;
	}

	public String getGoods_description() {
		return goods_description;
	}

	public void setGoods_description(String goods_description) {
		this.goods_description = goods_description;
	}

	public int getGoodsnum() {
		return goodsnum;
	}

	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}

	public String getGoodspic() {
		return goodspic;
	}

	public void setGoodspic(String goodspic) {
		this.goodspic = goodspic;
	}

	public double getGoods_total_price() {
		return goods_total_price;
	}

	public void setGoods_total_price(double goods_total_price) {
		this.goods_total_price = goods_total_price;
	}

	public OrderDetail(int o_orderid, int goodsid, String goodsname, double goodsprice, String goods_description,
			int goodsnum, String goodspic, double goods_total_price) {
		super();
		this.o_orderid = o_orderid;
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.goodsprice = goodsprice;
		this.goods_description = goods_description;
		this.goodsnum = goodsnum;
		this.goodspic = goodspic;
		this.goods_total_price = goods_total_price;
	}

	public OrderDetail() {
		super();
	}


}
