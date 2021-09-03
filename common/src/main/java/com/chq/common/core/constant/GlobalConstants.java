package com.chq.common.core.constant;

public interface GlobalConstants {

    Boolean STATUS_DELETED = true;

    Boolean STATUS_NON_DELETED = false;

    String DEFAULT_USER_PASSWORD = "123456";

    Integer DELETED_VALUE = 1;

    String ROOT_ROLE_CODE = "role_root";

    String ADMIN_ROLE_CODE = "role_admin";

    Integer USER_INNER = 1;

    Integer USER_OUTSIDE = 2;

    String URL_PERM_ROLES_KEY = "system:permission:url_perm_roles:";
    String BTN_PERM_ROLES_KEY = "system:permission:btn_perm_roles:";

    String ALL_BTN_PERMISSION = "*:*:*";

    String HEADER_CRUMB_APP_ID = "X-CRUMB-APP-ID";

    String HEADER_CRUMB_UID = "X-CRUMB-UID";

    String HEADER_CRUMB_USER_NAME = "X-CRUMB-USER-NAME";

    String HEADER_CRUMB_JTI = "X-CRUMB-JTI";

    String HEADER_CRUMB_EXP = "X-CRUMB-EXP";

    String HEADER_TMS_UID = "X-TMS-UID";

    String HEADER_TMS_ID = "X-TMS-ID";

    String HEADER_TMS_JTI = "X-TMS-JTI";

    String HEADER_TMS_EXP = "X-TMS-EXP";

    String HEADER_TMS_USERNAME = "X-TMS-USER-NAME";

    String HEADER_TMS_NAME = "X-TMS-NAME";

    String HEADER_TMS_DEPT_CODE = "X_TMS_DEPT_CODE";

    String HEADER_USER = "X_USER_INFO";

    String HEADER_CUR_ORG = "X-CUR-ORG";

    String REQUEST_ID = "REQUEST_ID";

    String HEADER_APP_ID = "X-APP-ID";


}
