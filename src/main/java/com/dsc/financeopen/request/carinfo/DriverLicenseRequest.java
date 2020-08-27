package com.dsc.financeopen.request.carinfo;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class DriverLicenseRequest extends OpenRequestParam<DriverLicenseResponse,DriverLicenseRequest.Wrapper> {


    private static final String API = "com.souche.financeplatform.infocenter.api.facade.LicenseQueryFacade#queryDriverLicense";


    public DriverLicenseRequest() {
        super(API);
        setData(new DriverLicenseRequest.Wrapper(this));
    }

    @Override
    public Class<DriverLicenseResponse> getResultClass() {
        return DriverLicenseResponse.class;
    }

    @Data
    public static class Wrapper {

        public Wrapper(DriverLicenseRequest licenseQueryQry) {
            this.licenseQueryQry = licenseQueryQry;
        }

        private DriverLicenseRequest licenseQueryQry;
    }

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idCard;

}
