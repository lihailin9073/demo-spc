package com.wzliulan.demo.spc.goods.common.utils;

import com.wzliulan.demo.spc.goods.common.vo.ResultVo;

public class ResultVoUtil {

    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo<>();
        resultVo.setCode(200);
        resultVo.setData(data);
        resultVo.setMessage("操作成功");
        return resultVo;
    }

    public static ResultVo success(String message, Object data) {
        ResultVo resultVo = new ResultVo<>();
        resultVo.setCode(200);
        resultVo.setData(data);
        resultVo.setMessage(message);
        return resultVo;
    }

    public static ResultVo error() {
        ResultVo resultVo = new ResultVo<>();
        resultVo.setCode(-200);
        resultVo.setMessage("操作失败");
        return resultVo;
    }
}
