package com.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneratorCode {
    @NotEmpty(message = "tableNameList参数不能为空")
    private List<String> tableNameList;
    private String author = "Mystery Men";
    private String commentDate = "yyyy年MM月dd日";
    private String outputDir = Paths.get(System.getProperty("user.dir")).toAbsolutePath().toString();
    private String parentPackage = "com";
    private String modulePackage = "demo";

    public List<String> getTableNameList() {
        return tableNameList;
    }

    public void setTableNameList(List<String> tableNameList) {
        this.tableNameList = tableNameList;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getOutputDir() {
        return outputDir + File.separator + modulePackage + File.separator + "main" + File.separator + "java";
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getParentPackage() {
        return parentPackage;
    }

    public void setParentPackage(String parentPackage) {
        this.parentPackage = parentPackage;
    }

    public String getModulePackage() {
        return modulePackage;
    }

    public void setModulePackage(String modulePackage) {
        this.modulePackage = modulePackage;
    }

    public String getPath(){
        return outputDir + File.separator + modulePackage;
    }

}
