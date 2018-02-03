package com.lichao.chaovolley.http.download.interfaces;

import com.lichao.chaovolley.http.download.DownloadItemInfo;

/**
 * Created by Administrator on 2018-02-03.
 */

public interface IDownloadServiceCallable {

    void onDownloadStatusChanged(DownloadItemInfo downloadItemInfo);

    void onTotalLengthReceived(DownloadItemInfo downloadItemInfo);

    void onCurrentSizeChanged(DownloadItemInfo downloadItemInfo, double downLenth, long speed);

    void onDownloadSuccess(DownloadItemInfo downloadItemInfo);

    void onDownloadPause(DownloadItemInfo downloadItemInfo);

    void onDownloadError(DownloadItemInfo downloadItemInfo, int var2, String var3);
}
