/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package util;

public class Constants {
	
	public static final String htmlHead = "<head>\r\n    <meta charset=\"utf-8\">\r\n    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\r\n    <title>Climate Service</title>\r\n\r\n    <!-- Bootstrap -->\r\n    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n\r\n    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\r\n    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n    <!--[if lt IE 9]>\r\n    <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n    <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n    <![endif]-->\r\n</head>\r\n<body>\r\n\r\n<h2 class=\"text-center\">Service: 2-D Variable Map</h2>\r\n\r\n<p class=\"text-center col-md-8 col-md-offset-2\">This service generates a map of a 2-dimensional variable with time\r\n    averaging and spatial\r\n    subsetting. Select a data source (model or observation), a variable name, a time range, and a spatial range\r\n    (lat-lon box) below.\r\n</p>\r\n\r\n<div class=\"container col-md-6\">\r\n    <form>\r\n        <table class=\"table table-bordered table-striped\">\r\n            <thead>\r\n            <tr>\r\n                <th class=\"col-md-2\">Parameter Name</th>\r\n                <th class=\"col-md-4\">Value</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody>\r\n";
	
	public static final String htmlTail = "</tbody>\r\n        </table>\r\n        <div class=\"text-center\">\r\n            <button type=\"submit\" class=\"btn btn-success btn-lg\">Get Plot</button>\r\n        </div>\r\n    </form>\r\n</div>\r\n\r\n<div class=\"container col-md-6\">\r\n    <form>\r\n        <table class=\"table table-bordered table-striped\">\r\n            <thead>\r\n            <tr>\r\n                <th>Output</th>\r\n            </tr>\r\n            </thead>\r\n            <tbody>\r\n            <tr>\r\n                <td>\r\n                    <a href=\"http://einstein.sv.cmu.edu:9002/static/twoDimMap/6879a2eedd1910f4c45e6213d342e066/nasa_modis_clt_200401_200412_Annual.jpeg\">\r\n                        <img src=\"http://einstein.sv.cmu.edu:9002/static/twoDimMap/6879a2eedd1910f4c45e6213d342e066/nasa_modis_clt_200401_200412_Annual.jpeg\"\r\n                             class=\"img-responsive\">\r\n                    </a>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <a href=\"http://einstein.sv.cmu.edu:9002/static/twoDimMap/6879a2eedd1910f4c45e6213d342e066/nasa_modis_clt_200401_200412_Annual.jpeg\">\r\n                        <textarea class=\"form-control\" rows=\"3\" id=\"comment\">http://einstein.sv.cmu.edu:9002/static/twoDimMap/6879a2eedd1910f4c45e6213d342e066/nasa_modis_clt_200401_200412_Annual.jpeg</textarea>\r\n                    </a>\r\n                </td>\r\n            </tr>\r\n            <tr>\r\n                <td>\r\n                    <textarea class=\"form-control\" rows=\"10\" id=\"comment\">\r\n                        {\r\n    \"dataUrl\": \"http://einstein.sv.cmu.edu:9002/static/twoDimMap/3cce4d6630dd6a3f9b9b2155a2d95ff6/nasa_modis_clt_200401_200412_JFMAJASOND.nc\",\r\n    \"message\": \"program name: octaveWrapper\\nsourceName: nasa_modis\\nvarName: clt\\nstartTimeStr: 200401\\nstopTimeStr: 200412\\nlonRange: 0,360\\nlonRange: 0.000000\\nlonRange: 360.000000\\nlatRange: -90,90\\n1. NASA_MODIS\\n2. clt\\n3. 200401\\n4. 200412\\n5. 0,360\\n6. -90,90\\n7. 1,2,3,4,7,8,9,10,11,12\\n8. /media/sdb/trunk/services/svc/svc/static/twoDimMap/3cce4d6630dd6a3f9b9b2155a2d95ff6\\n9. 0\\nstart year = 2000.000000\\n, month = 3.000000\\nstop year = 2011.000000\\n, month = 9.000000\\nfigFile: nasa_modis_clt_200401_200412_JFMAJASOND.jpeg\\nfigFilePath: /media/sdb/trunk/services/svc/svc/static/twoDimMap/3cce4d6630dd6a3f9b9b2155a2d95ff6/nasa_modis_clt_200401_200412_JFMAJASOND.jpeg\\ndataFile: nasa_modis_clt_200401_200412_JFMAJASOND.nc\\ndataFilePath: /media/sdb/trunk/services/svc/svc/static/twoDimMap/3cce4d6630dd6a3f9b9b2155a2d95ff6/nasa_modis_clt_200401_200412_JFMAJASOND.nc\\nnumber of month = 12\\nnumber of files = 1\\n+-----------------------------------------------------------------------------+\\n|                                                                             |\\n|       Total Cloud Fraction, 2004/01-2004/12 climatology (%), JFMAJASOND     |\\n|   latitude(deg)                                                             |\\n|         +-----------------------------------------------------------+       |\\n|         | ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|       |\\n|      50 |+++++++         ++    +++++++++++++++++++++++++++++++  ++++|       |\\n|         |++++++++++ ++      ++++++             ++    +++++++   ++ ++|       |\\n|         | +++++++++++ +++ +++++          ++     +++++++++++      ++ |       |\\n|       0 |+++ +++++  +++++++++++                     +++++++++    +++|       |\\n|         |++  ++++       +++++++++++++ +              ++++  ++++     |       |\\n|         | ++ ++++++        ++++++++++ +    +            +  +++      |       |\\n|         |  +++     ++      +++++++  ++++               +++++        |       |\\n|     -50 |+         ++                                  ++++++ +    +|       |\\n|         |++++++++++++++++++++++++++++    +++++++++++++++++++++++++++|       |\\n|         +-----------------------------------------------------------+       |\\n|         0      50       100     150     200      250     300     350        |\\n|                                longitude(deg)                               |\\n|         +-----------------------------------------------------------+       |\\n|         +-----------------------------------------------------------+       |\\n|            10    20     30    40     50    60    70     80    90            |\\n|                           Total Cloud Fraction (%)                          |\\n|                                                                             |\\n+-----------------------------------------------------------------------------+\\n\\n  scalar structure containing the fields:\\n\\n    Name = /\\n    Format = classic\\n    Dimensions =\\n\\n      1x2 struct array containing the fields:\\n\\n        Name\\n        Length\\n        Unlimited\\n\\n    Variables =\\n\\n      1x3 struct array containing the fields:\\n\\n        Name\\n        Datatype\\n        Dimensions\\n        Attributes\\n\\n\",\r\n    \"success\": true,\r\n    \"url\": \"http://einstein.sv.cmu.edu:9002/static/twoDimMap/3cce4d6630dd6a3f9b9b2155a2d95ff6/nasa_modis_clt_200401_200412_JFMAJASOND.jpeg\"\r\n}\r\n                    </textarea>\r\n                </td>\r\n            </tr>\r\n            </tbody>\r\n        </table>\r\n        <div class=\"text-center\">\r\n            <button type=\"submit\" class=\"btn btn-success btn-lg\">Download Data</button>\r\n        </div>\r\n    </form>\r\n</div>\r\n\r\n<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\r\n<!-- Include all compiled plugins (below), or include individual files as needed -->\r\n<script src=\"js/bootstrap.min.js\"></script>\r\n</body>\r\n</html>\r\n";

	public static final String WORKFLOW_REPO = "WorkflowRepository";

	public static final String USER_REPO = "UserRepository";

	public static final String GROUP_USER_REPO = "GroupUsersRepository";

	public static final String COMMENT_REPO = "CommentRepository";

	public static final String TAG_REPO = "TagRepository";

	public static final String SUGGESTION_REPO = "SuggestionRepository";

	public static final String PARAMETER_REPO = "ParameterRepository";

	public static final String CLIMATE_SERVICE_REPO = "ClimateServiceRepo";

	public static final String MAIL_REPO = "MailRepository";

	public static final String INSTRUMENT_REPO = "InstrumentRepository";

	public static final String DATASET_REPO = "DatasetRepository";

	public static final String DATASET_LOG_REPO = "DatasetLogRepository";

	public static final String DATASET_ENTRY_REPO = "DatasetEntryRepository";

	public static final String REPLY_REPO = "ReplyRepository";

	public static final String SERVICE_ENTRY_REPO = "ServiceEntryRepository";

}
