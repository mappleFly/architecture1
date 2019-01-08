package com.sishuok.architecture1.common.vo;

import com.sishuok.pageutil.Page;
import lombok.Data;

@Data
public class BaseModel {

    private Integer uuid;
    private Page page = new Page();
}
