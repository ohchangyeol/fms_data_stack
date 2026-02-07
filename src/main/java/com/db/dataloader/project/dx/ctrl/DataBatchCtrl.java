package com.db.dataloader.project.dx.ctrl;

import com.db.dataloader.project.dx.dto.TableInfoDto;
import com.db.dataloader.project.dx.svc.DataBatchSvc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/data")
@CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
@RequiredArgsConstructor
public class DataBatchCtrl {

    private final DataBatchSvc dataBatchSvc;

    @PostMapping("/batchOneTable")
    public String batchOneTable(@RequestBody TableInfoDto tableInfoDto){
        dataBatchSvc.process(tableInfoDto);
        return "ok";
    }

    @PostMapping("/batchTableList")
    public String batchTableList(@RequestBody List<TableInfoDto> tableInfoList){
        for ( TableInfoDto tableInfoDto : tableInfoList){
            dataBatchSvc.process(tableInfoDto);
        }
        return "ok";
    }
}
