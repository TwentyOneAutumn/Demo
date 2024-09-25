package com.file.api;

import com.core.domain.Row;
import com.core.enums.ServiceInfo;
import com.file.api.domain.FileInfo;
import com.file.api.domain.MultipleFileInfo;
import com.file.api.domain.SingleFileInfo;
import com.file.api.factory.FileFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@FeignClient(contextId = "RemoteFileService",value = ServiceInfo.FILE,path = ServiceInfo.FILE_PATH,fallbackFactory = FileFallbackFactory.class)
public interface RemoteFileService {

    /**
     * 上传文件
     * @param singleFileUploadForm 文件对象
     * @return Row
     */
    @PostMapping("/upload")
    Row<FileInfo> upload(@Valid @ModelAttribute SingleFileInfo info);

    /**
     * 上传多文件
     * @param multipleFileUploadForm 文件对象
     * @return Row
     */
    @PostMapping("/uploads")
    Row<List<FileInfo>> uploads(@Valid @ModelAttribute MultipleFileInfo info);
}
