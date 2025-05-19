package ESRS_UTILS;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import utils.AuthTokenadminUtil;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_Reports {
	
	
	
	String admintoken;
	
	
	@BeforeClass
	public void getadmintoken() {
		
	admintoken= AuthTokenadminUtil.getAdminToken();
    RestAssured.baseURI = "https://qa.daato.app";
		
		}

		
		
		
		
		@Test
	    public void deleteAllReports() {
	        String[] reportIds = {
	            "6765223bd92a75524ff2acef", "67656d26d92a75524ff2f2f9", "676802465d1b3317d79bd4b2", "67692a045d1b3317d79be670",
	            "676a60c25d1b3317d79bf42d", "676a7eb14847cda4af9f95fa", "676d09e7099b8541aa696c12", "676e38c0099b8541aa696fa3",
	            "676e66addd7ce5c858dc8008", "676e6a06dd7ce5c858dc8474", "6773bae740fdd1908fe90768", "6773c05640fdd1908fe9124f",
	            "6777f4da38c984b33b6e85ae", "677cc1b36832667b4649893a", "677cc52b6832667b4649a2dc", "677cc6716832667b4649a5dc",
	            "677cd9c76832667b464a52cf", "677cfd846832667b464a80a8", "677d1cde7a21a2209eea8f2d", "677e39d7a43189cb8f082c1b",
	            "677e4ec9a43189cb8f087b65", "677e7911fe565104ab79a85b", "677e8146fe565104ab79bfd9", "677f6203fe565104ab79ca4a",
	            "677faf5f688a8fab2273f7ea", "677fc913688a8fab22741538", "6780b6eb1c2468bd1d179767", "6780d0620b7bd131dbc939e2",
	            "67851ce760d753aa873fe6a8", "6788e9f2b498ab474670c925", "67891a95b498ab474670dcec", "678b33006bb1d45999bf7989",
	            "678d28cf6bb1d45999bf7f8e", "678ddabd6bb1d45999bf8482", "678e43d1e30b87eb0e96c76c", "67909af72ce36de7aed929fe",
	            "67932dbcb6f2d72a13b2d699", "67932dbfb6f2d72a13b2ea94", "67965b3e19b559dcee4bb5b0", "6798c6b613a3e9a22b0462e7",
	            "6798cc4b13a3e9a22b048b8a", "6798de82a759ec5cb42723a6", "67a055b02b20a074c3ff212e", "67a084b52b20a074c3ffa76f",
	            "67a0a1132b20a074c3ffe302", "67a0a1182b20a074c3fffc07", "67a1aa288fa0c9ec63dd3f22", "67a1c3e88fa0c9ec63dd4eef",
	            "67a1c6288fa0c9ec63dd5a33", "67a1fcdf8fa0c9ec63de068c", "67a202af8fa0c9ec63de1ee8", "67a35bd5d7febef4d69456e7",
	            "67a35bd7d7febef4d6946ae2", "67a59e6f8f842e5ad5d548b5", "67a6fc3f68db44bb11274317", "67a9839168db44bb11278e39",
	            "67a993506f2920058ed1417e", "67a994c96f2920058ed15cdd", "67a995fe6f2920058ed15e3c", "67a9978384b86eb8683ce7bb",
	            "67a9a0ea84b86eb8683cfa04", "67a9a27184b86eb8683d0501", "67a9a3d084b86eb8683d1448", "67a9ec0b84b86eb8683dc9ca",
	            "67aa298abda4a5625f780ff2", "67aaed784b0230ce4d335b8f", "67aaee762a0aa3f1bf0fb1b3", "67aaf4032a0aa3f1bf0fb8d5",
	            "67ab0a082a0aa3f1bf0fd52a", "67ab28178b688ffac4cad067", "67ab28188b688ffac4cad075", "67ac33c8c88c6b765de96f2e",
	            "67b30289722df10857944f7b", "67b30de348baed258566e071", "67b5aca601db98216813a683", "67b6f1b96b541640e8a76709",
	            "67b6f1ba6b541640e8a76714", "67b81fbb62716ae305c6ad46", "67b8605f62716ae305c7106a", "67bc1523966657de7f580cc8",
	            "67bc3c97966657de7f58113d", "67bc5ea2ff41e8c8f990ef7e", "67bc684eff41e8c8f990f90f", "67bc8cedff41e8c8f991384d",
	            "67bd6599a1e59bda77e959b0", "67c01002a1e59bda77eb88c1", "67c01006a1e59bda77eb9c7e", "67c048e0a1e59bda77ec41b5",
	            "67c597e7a1e59bda77ed7a18", "67c6e5fa8e5cdcad52d00bb1", "67c6f37c8e5cdcad52d0654a", "67c80999a4a06d815f7d9ff8",
	            "67c8099ca4a06d815f7db719", "67c8099ca4a06d815f7db71b", "67c809a1a4a06d815f7de535", "67c80a00a4a06d815f7dffa3",
	            "67c98ceca4a06d815f7e76db", "67c98d7da4a06d815f7e7721", "67ce72ddce4661f05a8d35c3", "67cec5253fbca7996661b549",
	            "67cee148cc8178e52ce129cc", "67d02062cc8178e52ce1cbcb", "67d028a2cc8178e52ce1e3dc", "67d7bfd5cc8178e52ce31487",
	            "67d7dac8cc8178e52ce318b1", "67d9542ccc8178e52ce32211", "67dbadefcc8178e52ce371db", "67dbd1d112e57da528d8c7a2",
	            "67dd24e00ef14213f51150fa", "67dd24f90ef14213f51164f7", "67e0e468ac89c7015a6ad53f", "67e1564fac85572bb62071e1",
	            "67e15652ac85572bb6208aa5", "67e50433399ce7d055a782ac", "67eccc1d06015b2dbe922a9e", "67ecea2d821a033ab0c1ce2c",
	            "67ee6e2e8581acc03e396e54", "67ee78b38581acc03e39f0cc", "67ef6b488581acc03e39f483", "67ef82678581acc03e39febd",
	            "67f3747a2008239add22e81f", "67f4efe52008239add279218", "67f65a69e0867cb6037d8ddc", "67f6a4cde0867cb6037f16ed",
	            "67f8c1ca1ff884ebcbc50d09", "67f8cf231ff884ebcbc50f0c", "67f8fc091ff884ebcbc515b4", "67fc1a355c7ab701593f7527",
	            "67fcbbcba1b013dc7f731f15", "67fcd9e0a1b013dc7f737b7f", "67fe39b82cc450ac4597fdef", "67fe6f133894bb2f0ee01136",
	            "67ff57683894bb2f0ee06a15", "67ff57683894bb2f0ee06a18", "6800ff16926efc966b95d879", "68012e87926efc966b95e2fa",
	            "6801e535926efc966b95e904", "6801e5cc926efc966b95e959", "680241506b491f99246bd10b", "68074a4a078493b3cf576450",
	            "68074b6c078493b3cf57653c", "68077133983bed769de9ec50", "68077806983bed769de9ee0e", "68077826983bed769de9ee2f",
	            "68088bd7983bed769dea8598", "68088c09983bed769dea86ab", "68088c27983bed769dea86ba", "68089b1d983bed769deb7020",
	            "6808b957983bed769decdf02", "680f2f21aaf2b21e1605c638", "6810bd30aaf2b21e16073679", "6811bdc0165bd52f0dc8c8c2",
	            "6811c859165bd52f0dc9308b", "6811c9df165bd52f0dc94a1d", "6819c60d2ae94f4d3ed66679"
	        };

	        for (String reportId : reportIds) {
	            Response response = given()
	                    .header("Authorization", "Bearer " + admintoken)
	                    .when()
	                    .delete("/api/esrs/disclosure-reporting/" + reportId)
	                    .then()
	                    .log().all()
	                    .extract().response();

	            System.out.println("Deleted Report ID: " + reportId + " | Status Code: " + response.getStatusCode());
	        }  
		
		
		}
		
		
}


