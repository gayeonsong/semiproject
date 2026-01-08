package com.example.demo.pageInfo;

import lombok.Getter;

@Getter
public class PageInfo {
    private int pageNum;
    private int rowBlockNum;
    private int pageBlockNum;
    private int totalRowNum;

    private int startRowNum;
    private int endRowNum;
    private int startPageNum;
    private int endPageNum;
    private int totalPageNum;

    public PageInfo(int pageNum, int rowBlockNum, int pageBlockNum, int totalRowNum){
        this.pageNum=pageNum;
        this.pageBlockNum=pageBlockNum;
        this.totalRowNum=totalRowNum;
        this.rowBlockNum=rowBlockNum;

        startRowNum=(pageNum-1)*rowBlockNum+1;
        endRowNum=startRowNum+(rowBlockNum-1);
        startPageNum=(pageNum-1)/pageBlockNum*pageBlockNum+1;
        int tempEndPageNum=startPageNum+(pageBlockNum-1);
        totalPageNum=(int)Math.ceil(totalRowNum/(double)rowBlockNum);
        endPageNum=Math.min(tempEndPageNum,totalPageNum);
    }
}
