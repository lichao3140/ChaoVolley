package com.lichao.chaovolley.http.download;

import com.lichao.chaovolley.db.annotion.DbTable;
import com.lichao.chaovolley.http.HttpTask;

/**
 * Created by Administrator on 2018-02-02.
 */

@DbTable("t_downloadInfo")
public class DownloadItemInfo extends BaseEntity<DownloadItemInfo> {

    public long currentLength;

    public long totalLength;

    public transient HttpTask httpTask;


}
