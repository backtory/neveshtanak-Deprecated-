package ir.pegahtech.saas.client.shared.models;

import java.util.List;
import java.util.Date;
import ir.pegahtech.saas.client.shared.models.*;

public class FilterNode {

	public static final String OP = "op";
	public static final String RIGHT = "right";
	public static final String LEFT = "left";

	private String op;
	private FilterNode right;
	private FilterNode left;
	
	public FilterNode (){

	}

	public FilterNode (FilterNode left,String op,FilterNode right){
		this.left = left;
		this.op = op;
		this.right = right;

	}

	public FilterNode (String op){
		this.op = op;

	}

	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public FilterNode getRight() {
		return right;
	}
	public void setRight(FilterNode right) {
		this.right = right;
	}
	public FilterNode getLeft() {
		return left;
	}
	public void setLeft(FilterNode left) {
		this.left = left;
	}

}
