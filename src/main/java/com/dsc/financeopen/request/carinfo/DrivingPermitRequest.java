package com.dsc.financeopen.request.carinfo;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class DrivingPermitRequest extends OpenRequestParam<DrivingPermitResponse, DrivingPermitRequest.Wrapper> {


    private static final String API = "com.souche.financeplatform.infocenter.api.facade.LicenseQueryFacade#queryDrivingPermit";


    public DrivingPermitRequest() {
        super(API);
        setData(new DrivingPermitRequest.Wrapper(this));
    }


    @Override
    public Class<DrivingPermitResponse> getResultClass() {
        return DrivingPermitResponse.class;
    }

    @Data
    public static class Wrapper {

        public Wrapper(DrivingPermitRequest licenseQueryQry) {
            this.licenseQueryQry = licenseQueryQry;
        }

        private DrivingPermitRequest licenseQueryQry;
    }

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 车牌号
     */
    private String licenseNo;
}
