package com.team.back.common.response;

public interface ResponseCode {

  String SUCCESS = "SU";

  String VALIDATE_FAIL = "VF";

  String EXISTED_EMAIL = "EE";
  String EXISTED_NICKNAME = "EN";
  String EXISTED_TEL_NUMBER = "ET";
  String EXISTED_STORE_NUMBER = "ESN";

  String NO_EXISTED_USER = "NU";
  String NO_EXISTED_BOARD = "NB";
  String NO_EXISTED_COMMENT = "NC";
  String NO_EXISTED_STORE = "NS";

  String NO_PERMISSION = "NP";

  String SIGN_IN_FAIL = "DM";

  String DATABASE_ERROR = "DE";

  String NOT_ADMIN_ID = "NA";
  
}
