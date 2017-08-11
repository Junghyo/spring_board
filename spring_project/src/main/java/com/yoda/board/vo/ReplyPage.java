package com.yoda.board.vo;

public class ReplyPage {
	public static final int PAGE_SCALE=10;
	public static final int BLOCK_SCALE=4;
	
	private int curPage;
	private int prePage;
	private int nextPage;
	private int totPage;
	private int curBlock;
	private int preBlock;
	private int nextBlock;
	private int totBlock;
	private int pageStart;
	private int pageEnd;
	private int blockStart;
	private int blockEnd;
	
	public ReplyPage(int count, int curPage){
		curBlock = 1;
		this.curPage = curPage;
		setTotPage(count);
		setPageRange();
		setTotBlock();
		setBlockRange();
	}
	
	public void setBlockRange(){
		curBlock = (int) (Math.ceil((curPage-1)/BLOCK_SCALE)+1);
		blockStart = (curPage-1)*BLOCK_SCALE+1;
		blockEnd = blockStart+BLOCK_SCALE-1;
		if(blockEnd > totPage) blockEnd = totPage;
		prePage = (curPage==1)? 1:(curBlock-1)*BLOCK_SCALE;
		nextPage = curBlock > totBlock ? (curBlock*BLOCK_SCALE) : (curBlock*BLOCK_SCALE)+1;
		if(nextPage>=totPage) nextPage = totPage;
	}
	public void setPageRange(){
		pageStart = (curPage-1)*PAGE_SCALE+1;
		pageEnd = pageStart+PAGE_SCALE-1;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int count) {
		totPage = (int) Math.ceil(count*1.0/PAGE_SCALE);
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPreBlock() {
		return preBlock;
	}

	public void setPreBlock(int preBlock) {
		this.preBlock = preBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getTotBlock() {
		return totBlock;
	}

	public void setTotBlock() {
		totBlock = (int) Math.ceil(totPage/BLOCK_SCALE);
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockStart() {
		return blockStart;
	}

	public void setBlockStart(int blockStart) {
		this.blockStart = blockStart;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	
	
}
