package com.jrestless.aws.examples;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("/sample")
public class SampleResource {
	@GET
	@Path("/health")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getHealthStatus() {
		return Response.ok(new HealthStatusResponse("up and running")).build();
	}
	static class HealthStatusResponse {
		private final String statusMessage;
		HealthStatusResponse(String statusMessage) {
			this.statusMessage = statusMessage;
		}
		public String getStatusMessage() {
			return statusMessage;
		}
	}
	@GET
	@Path("/idSessao")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Sessao getIdSession() throws IOException{
		Client client = ClientBuilder.newBuilder().build();
		
		//WebTarget target = client.target("http://127.0.0.1:8080/cap04/rest/estoque/1");
		//WebTarget target = client.target("http://127.0.0.1:8080/cap04/rest/estoque/imagem/2");
		//WebTarget target = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions?email=luciano.souzaviana@gmail.com&token=5AB0A6A9CC72418B9D44DE3D18B56260");
		//Response response = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions").queryParam("email", "luciano.souzaviana@gmail.com").queryParam("token", "5AB0A6A9CC72418B9D44DE3D18B56260").request().get();
		WebTarget target = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions");
		Form form = new Form();
		form.param("email", "luciano.souzaviana@gmail.com");
		form.param("token", "5AB0A6A9CC72418B9D44DE3D18B56260");
		
		Response response = target.request().post(Entity.entity(form,  MediaType.APPLICATION_FORM_URLENCODED_TYPE));
		//if(response.getStatus() == Status.CREATED.getStatusCode()){
		//	System.out.println("FOI CRIAADA A SESSAO");
		//}
		
		//Fruta fruta = response.readEntity(Fruta.class);
		Sessao sessao = response.readEntity(Sessao.class);
		String idSessaoStr = sessao.getId().toString();
		//response.close();
		System.out.println("BUSCA DE ID DA SESSAO=" + idSessaoStr);
		//gravaIdSessao(idSessaoStr);
		return sessao;
	}
	@GET
	@Path("/transaction")
	//@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML + ";charset=UTF-8")	
	public String getTransaction(
			@Context UriInfo uriInfo
			) throws IOException{
		Client client = ClientBuilder.newBuilder().build();
		
		//WebTarget target = client.target("http://127.0.0.1:8080/cap04/rest/estoque/1");
		//WebTarget target = client.target("http://127.0.0.1:8080/cap04/rest/estoque/imagem/2");
		//WebTarget target = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions?email=luciano.souzaviana@gmail.com&token=5AB0A6A9CC72418B9D44DE3D18B56260");
		//Response response = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions").queryParam("email", "luciano.souzaviana@gmail.com").queryParam("token", "5AB0A6A9CC72418B9D44DE3D18B56260").request().get();
		//WebTarget target = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions");
		WebTarget target = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/transactions");
		MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
//      String senderEmail = queryParams.getFirst("senderEmail");
//      String senderName = queryParams.getFirst("senderName");
//      String senderCPF = queryParams.getFirst("senderCPF");
//      String senderAreaCode = queryParams.getFirst("senderAreaCode");
//      String senderPhone = queryParams.getFirst("senderPhone");        

//      String shippingAddressStreet = queryParams.getFirst("shippingAddressStreet");        
//      String shippingAddressNumber = queryParams.getFirst("shippingAddressNumber");
//      String shippingAddressComplement = queryParams.getFirst("shippingAddressComplement");        
//      String shippingAddressDistrict = queryParams.getFirst("shippingAddressDistrict");        
//      String shippingAddressPostalCode = queryParams.getFirst("shippingAddressPostalCode");
//      String shippingAddressCity = queryParams.getFirst("shippingAddressCity");
//      String shippingAddressState = queryParams.getFirst("shippingAddressState");
//      String shippingAddressCountry = queryParams.getFirst("shippingAddressCountry");
//      String shippingType = queryParams.getFirst("shippingType");
//      String shippingCost = queryParams.getFirst("shippingCost");
        
//      String creditCardToken = queryParams.getFirst("creditCardToken");
//      String creditCardHolderName = queryParams.getFirst("creditCardHolderName");        
//      String creditCardHolderCPF = queryParams.getFirst("creditCardHolderCPF");
//      String creditCardHolderBirthDate = queryParams.getFirst("creditCardHolderBirthDate");        
//      String creditCardHolderAreaCode = queryParams.getFirst("creditCardHolderAreaCode");
//      String creditCardHolderPhone = queryParams.getFirst("creditCardHolderPhone");
        
//      String billingAddressStreet = queryParams.getFirst("billingAddressStreet");        
//      String billingAddressNumber = queryParams.getFirst("billingAddressNumber");        
//      String billingAddressComplement = queryParams.getFirst("billingAddressComplement");        
//      String billingAddressDistrict = queryParams.getFirst("billingAddressDistrict");        
//      String billingAddressPostalCode = queryParams.getFirst("billingAddressPostalCode");
//      String billingAddressCity = queryParams.getFirst("billingAddressCity");        
//      String billingAddressState = queryParams.getFirst("billingAddressState");
//      String billingAddressCountry = queryParams.getFirst("billingAddressCountry");

//      String installmentQuantity = queryParams.getFirst("installmentQuantity");
//      String installmentValue = queryParams.getFirst("installmentValue");      
//      String noInterestInstallmentQuantity = queryParams.getFirst("noInterestInstallmentQuantity");
        
//      String extraAmount = queryParams.getFirst("extraAmount");
        
		//System.out.println("EMAIL PARAMETRO=" + senderEmail);
		//System.out.println("EMAIL NOME=" + senderName);		
//		Form form = new Form();

		Form form = new Form();		
		form.param("charset", "UTF-8");				
		form.param("email", "luciano.souzaviana@gmail.com");		
		form.param("token", "5AB0A6A9CC72418B9D44DE3D18B56260");
		//&paymentMode=default\
		form.param("paymentMode", "default");
		//		&paymentMethod=creditCard\
		form.param("paymentMethod", "creditCard");
		//		&receiverEmail=suporte@lojamodelo.com.br\
		form.param("receiverEmail", "luciano.souzaviana@gmail.com");
		//		&currency=BRL\
		form.param("currency", "BRL");
		for (Map.Entry<String, List<String>> queryEntry : queryParams.entrySet()) {
			
			String key = queryEntry.getKey();
			String val = queryEntry.getValue().get(0);
			System.out.println("key=" + key);
			System.out.println("val=" + val);
			form.param(key, val);
			//queryParameters.put(queryEntry.getKey(), new LinkedHashSet<>(queryEntry.getValue()));
			//String val = queryEntry.getValue().toArray();
			//form.param(queryEntry.getKey(), val);			
		}		
		
		//		&extraAmount=1.00
//		form.param("extraAmount", extraAmount);
		//		&itemId1=0001\
		
//		form.param("itemId1", "001");
		//		&itemDescription1=Notebook Prata\
//		form.param("itemDescription1", "Notebook Prata");
		//		&itemAmount1=24300.00\ 
//		form.param("itemAmount1", "24300.00");
//		&itemQuantity1=1\
//		form.param("itemQuantity1", "1");
//				&notificationURL=https://sualoja.com.br/notifica.html\
		form.param("notificationURL", "https://danbis.com.br/notifica.html");
		//		&reference=REF1234\ 
//		form.param("reference", "REF1234");
		//		&senderName=Jose Comprador\
//		form.param("senderName", senderName);
		//&senderCPF=22111944785\
//		form.param("senderCPF", senderCPF);
 		//		&senderAreaCode=11\
//		form.param("senderAreaCode", senderAreaCode);
//				&senderPhone=56273440\ 
//		form.param("senderPhone", senderPhone);		
//				&senderEmail=comprador@uol.com.br\
//		form.param("senderEmail", senderEmail);//"luciano.souzaviana@sandbox.pagseguro.com.br");
//				&senderHash=abc123\
		///form.param("senderHash", "abc123");
//				&shippingAddressStreet=Av. Brig. Faria Lima\
//		form.param("shippingAddressStreet", shippingAddressStreet);
//				&shippingAddressNumber=1384\ 
//		form.param("shippingAddressNumber", shippingAddressNumber);
//				&shippingAddressComplement=5o andar\
//		form.param("shippingAddressComplement", shippingAddressComplement);
//				&shippingAddressDistrict=Jardim Paulistano\
//		form.param("shippingAddressDistrict", shippingAddressDistrict);		
//				&shippingAddressPostalCode=01452002\
//		form.param("shippingAddressPostalCode", shippingAddressPostalCode);		
//				&shippingAddressCity=Sao Paulo\
//		form.param("shippingAddressCity", shippingAddressCity);		
//				&shippingAddressState=SP\
//		form.param("shippingAddressState", shippingAddressState);		
//				&shippingAddressCountry=BRA
//		form.param("shippingAddressCountry", shippingAddressCountry);		
//				&shippingType=1 
//		form.param("shippingType", shippingType);		
//				&shippingCost=1.00
//		form.param("shippingCost", shippingCost);		
//				&creditCardToken=4as56d4a56d456as456dsa\
//		form.param("creditCardToken", creditCardToken);//"fc9f8a033c734f6cbed7d980f5c0d7af");		
//				&installmentQuantity=5\
//		form.param("installmentQuantity", installmentQuantity);		
//				&installmentValue=125.22\
//		form.param("installmentValue", installmentValue);		
//				&noInterestInstallmentQuantity=2\
//		form.param("noInterestInstallmentQuantity", noInterestInstallmentQuantity);		
//				&creditCardHolderName=Jose Comprador\
//		form.param("creditCardHolderName", creditCardHolderName);		
//				&creditCardHolderCPF=22111944785\
//		form.param("creditCardHolderCPF", creditCardHolderCPF);//"22111944785");		
//				&creditCardHolderBirthDate=27/10/1987\
//		form.param("creditCardHolderBirthDate", creditCardHolderBirthDate);		
//				&creditCardHolderAreaCode=11\
//		form.param("creditCardHolderAreaCode", creditCardHolderAreaCode);		
//				&creditCardHolderPhone=56273440
//form.param("creditCardHolderPhone", creditCardHolderPhone);		
//				&billingAddressStreet=Av. Brig. Faria Lima\
//form.param("billingAddressStreet", billingAddressStreet);		
//				&billingAddressNumber=1384\
//form.param("billingAddressNumber", billingAddressNumber);		
//				&billingAddressComplement=5o andar\
//form.param("billingAddressComplement", billingAddressComplement);		
//				&billingAddressDistrict=Jardim Paulistano\
//form.param("billingAddressDistrict", billingAddressDistrict);
//				&billingAddressPostalCode=01452002\
//form.param("billingAddressPostalCode", billingAddressPostalCode);		
//				&billingAddressCity=Sao Paulo\
//form.param("billingAddressCity", billingAddressCity);		
//				&billingAddressState=SP\
//form.param("billingAddressState", billingAddressState);		
//				&billingAddressCountry=BRA\"	
//form.param("billingAddressCountry", billingAddressCountry);		
		//target.property(ClientProperties, value)
		//Response response = target.request().post(Entity.entity(form,  MediaType.APPLICATION_XML + ";charset=iso-8859-1"));
		Response response = target.request().post(Entity.entity(form,  MediaType.APPLICATION_FORM_URLENCODED_TYPE + ";charset=utf-8"));
		
		//if(response.getStatus() == Status.CREATED.getStatusCode()){
		//	System.out.println("FOI CRIAADA A SESSAO");
		//}
		
		//Fruta fruta = response.readEntity(Fruta.class);
		//Sessao sessao = response.readEntity(Sessao.class);
		//String idSessaoStr = sessao.getId().toString();
		//response.close();
		String output = response.readEntity(String.class);
		System.out.println("TRANSACTION 5 NOVA=" + output);  //idSessaoStr);
		//gravaIdSessao(idSessaoStr);
		//String output = response.readEntity(String.class);
		return output;
	}	
/*	@GET
	@Path("/transactions")
	//@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String getTransactions() throws IOException{
		Client client = ClientBuilder.newBuilder().build();
		
		//WebTarget target = client.target("http://127.0.0.1:8080/cap04/rest/estoque/1");
		//WebTarget target = client.target("http://127.0.0.1:8080/cap04/rest/estoque/imagem/2");
		//WebTarget target = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions?email=luciano.souzaviana@gmail.com&token=5AB0A6A9CC72418B9D44DE3D18B56260");
		//Response response = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions").queryParam("email", "luciano.souzaviana@gmail.com").queryParam("token", "5AB0A6A9CC72418B9D44DE3D18B56260").request().get();
		//WebTarget target = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions");
		WebTarget target = client.target("https://ngxept8qad.execute-api.us-east-1.amazonaws.com/dev/accounts/1234/transactions");
		Form form = new Form();
		form.param("transaction_id", "foo");
		form.param("amount", "20.50");
		//&paymentMode=default\
		Response response = target.request().post(Entity.entity(form,  MediaType.APPLICATION_FORM_URLENCODED_TYPE));
		//if(response.getStatus() == Status.CREATED.getStatusCode()){
		//	System.out.println("FOI CRIAADA A SESSAO");
		//}
		
		//Fruta fruta = response.readEntity(Fruta.class);
		//Sessao sessao = response.readEntity(Sessao.class);
		//String idSessaoStr = sessao.getId().toString();
		//response.close();
		String output = response.readEntity(String.class);
		System.out.println("TRANSACTIONS DYNAMODB =" + output);  //idSessaoStr);
		//gravaIdSessao(idSessaoStr);
		//String output = response.readEntity(String.class);
		return output;
	}*/	
/*	@POST
	@Path("/postOrderServiceBling")
	//@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_XML + ";charset=UTF-8")	
	public String postOrderServiceBling(
			@Context UriInfo uriInfo
			) throws IOException{
		//Client client = ClientBuilder.newBuilder().build();
		
		//WebTarget target = client.target("http://127.0.0.1:8080/cap04/rest/estoque/1");
		//WebTarget target = client.target("http://127.0.0.1:8080/cap04/rest/estoque/imagem/2");
		//WebTarget target = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions?email=luciano.souzaviana@gmail.com&token=5AB0A6A9CC72418B9D44DE3D18B56260");
		//Response response = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions").queryParam("email", "luciano.souzaviana@gmail.com").queryParam("token", "5AB0A6A9CC72418B9D44DE3D18B56260").request().get();
		//WebTarget target = client.target("https://ws.sandbox.pagseguro.uol.com.br/v2/sessions");
		//WebTarget target = client.target("https://bling.com.br/Api/v2/pedido/json");
		//aquiMultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
//      String senderEmail = queryParams.getFirst("senderEmail");
//      String senderName = queryParams.getFirst("senderName");
//      String senderCPF = queryParams.getFirst("senderCPF");
//      String senderAreaCode = queryParams.getFirst("senderAreaCode");
//      String senderPhone = queryParams.getFirst("senderPhone");        

//      String shippingAddressStreet = queryParams.getFirst("shippingAddressStreet");        
//      String shippingAddressNumber = queryParams.getFirst("shippingAddressNumber");
//      String shippingAddressComplement = queryParams.getFirst("shippingAddressComplement");        
//      String shippingAddressDistrict = queryParams.getFirst("shippingAddressDistrict");        
//      String shippingAddressPostalCode = queryParams.getFirst("shippingAddressPostalCode");
//      String shippingAddressCity = queryParams.getFirst("shippingAddressCity");
//      String shippingAddressState = queryParams.getFirst("shippingAddressState");
//      String shippingAddressCountry = queryParams.getFirst("shippingAddressCountry");
//      String shippingType = queryParams.getFirst("shippingType");
//      String shippingCost = queryParams.getFirst("shippingCost");
        
//      String creditCardToken = queryParams.getFirst("creditCardToken");
//      String creditCardHolderName = queryParams.getFirst("creditCardHolderName");        
//      String creditCardHolderCPF = queryParams.getFirst("creditCardHolderCPF");
//      String creditCardHolderBirthDate = queryParams.getFirst("creditCardHolderBirthDate");        
//      String creditCardHolderAreaCode = queryParams.getFirst("creditCardHolderAreaCode");
//      String creditCardHolderPhone = queryParams.getFirst("creditCardHolderPhone");
        
//      String billingAddressStreet = queryParams.getFirst("billingAddressStreet");        
//      String billingAddressNumber = queryParams.getFirst("billingAddressNumber");        
//      String billingAddressComplement = queryParams.getFirst("billingAddressComplement");        
//      String billingAddressDistrict = queryParams.getFirst("billingAddressDistrict");        
//      String billingAddressPostalCode = queryParams.getFirst("billingAddressPostalCode");
//      String billingAddressCity = queryParams.getFirst("billingAddressCity");        
//      String billingAddressState = queryParams.getFirst("billingAddressState");
//      String billingAddressCountry = queryParams.getFirst("billingAddressCountry");

//      String installmentQuantity = queryParams.getFirst("installmentQuantity");
//      String installmentValue = queryParams.getFirst("installmentValue");      
//      String noInterestInstallmentQuantity = queryParams.getFirst("noInterestInstallmentQuantity");
        
//      String extraAmount = queryParams.getFirst("extraAmount");
        
		//System.out.println("EMAIL PARAMETRO=" + senderEmail);
		//System.out.println("EMAIL NOME=" + senderName);		
//		Form form = new Form();

//		Form form = new Form();
//		form.param("charset", "UTF-8");		
		form.param("charset", "UTF-8");				
		form.param("email", "luciano.souzaviana@gmail.com");		
		form.param("token", "5AB0A6A9CC72418B9D44DE3D18B56260");
		//&paymentMode=default\
		form.param("paymentMode", "default");
		//		&paymentMethod=creditCard\
		form.param("paymentMethod", "creditCard");
		//		&receiverEmail=suporte@lojamodelo.com.br\
		form.param("receiverEmail", "luciano.souzaviana@gmail.com");
		//		&currency=BRL\
		form.param("currency", "BRL");
		for (Map.Entry<String, List<String>> queryEntry : queryParams.entrySet()) {
			
			String key = queryEntry.getKey();
			String val = queryEntry.getValue().get(0);
			System.out.println("key=" + key);
			System.out.println("val=" + val);
			form.param(key, val);
			//queryParameters.put(queryEntry.getKey(), new LinkedHashSet<>(queryEntry.getValue()));
			//String val = queryEntry.getValue().toArray();
			//form.param(queryEntry.getKey(), val);			
		}		
		
		//		&extraAmount=1.00
//		form.param("extraAmount", extraAmount);
		//		&itemId1=0001\
		
//		form.param("itemId1", "001");
		//		&itemDescription1=Notebook Prata\
//		form.param("itemDescription1", "Notebook Prata");
		//		&itemAmount1=24300.00\ 
//		form.param("itemAmount1", "24300.00");
//		&itemQuantity1=1\
//		form.param("itemQuantity1", "1");
//				&notificationURL=https://sualoja.com.br/notifica.html\
//		form.param("notificationURL", "https://danbis.com.br/notifica.html");
		//		&reference=REF1234\ 
//		form.param("reference", "REF1234");
		//		&senderName=Jose Comprador\
//		form.param("senderName", senderName);
		//&senderCPF=22111944785\
//		form.param("senderCPF", senderCPF);
 		//		&senderAreaCode=11\
//		form.param("senderAreaCode", senderAreaCode);
//				&senderPhone=56273440\ 
//		form.param("senderPhone", senderPhone);		
//				&senderEmail=comprador@uol.com.br\
//		form.param("senderEmail", senderEmail);//"luciano.souzaviana@sandbox.pagseguro.com.br");
//				&senderHash=abc123\
		///form.param("senderHash", "abc123");
//				&shippingAddressStreet=Av. Brig. Faria Lima\
//		form.param("shippingAddressStreet", shippingAddressStreet);
//				&shippingAddressNumber=1384\ 
//		form.param("shippingAddressNumber", shippingAddressNumber);
//				&shippingAddressComplement=5o andar\
//		form.param("shippingAddressComplement", shippingAddressComplement);
//				&shippingAddressDistrict=Jardim Paulistano\
//		form.param("shippingAddressDistrict", shippingAddressDistrict);		
//				&shippingAddressPostalCode=01452002\
//		form.param("shippingAddressPostalCode", shippingAddressPostalCode);		
//				&shippingAddressCity=Sao Paulo\
//		form.param("shippingAddressCity", shippingAddressCity);		
//				&shippingAddressState=SP\
//		form.param("shippingAddressState", shippingAddressState);		
//				&shippingAddressCountry=BRA
//		form.param("shippingAddressCountry", shippingAddressCountry);		
//				&shippingType=1 
//		form.param("shippingType", shippingType);		
//				&shippingCost=1.00
//		form.param("shippingCost", shippingCost);		
//				&creditCardToken=4as56d4a56d456as456dsa\
//		form.param("creditCardToken", creditCardToken);//"fc9f8a033c734f6cbed7d980f5c0d7af");		
//				&installmentQuantity=5\
//		form.param("installmentQuantity", installmentQuantity);		
//				&installmentValue=125.22\
//		form.param("installmentValue", installmentValue);		
//				&noInterestInstallmentQuantity=2\
//		form.param("noInterestInstallmentQuantity", noInterestInstallmentQuantity);		
//				&creditCardHolderName=Jose Comprador\
//		form.param("creditCardHolderName", creditCardHolderName);		
//				&creditCardHolderCPF=22111944785\
//		form.param("creditCardHolderCPF", creditCardHolderCPF);//"22111944785");		
//				&creditCardHolderBirthDate=27/10/1987\
//		form.param("creditCardHolderBirthDate", creditCardHolderBirthDate);		
//				&creditCardHolderAreaCode=11\
//		form.param("creditCardHolderAreaCode", creditCardHolderAreaCode);		
//				&creditCardHolderPhone=56273440
//form.param("creditCardHolderPhone", creditCardHolderPhone);		
//				&billingAddressStreet=Av. Brig. Faria Lima\
//form.param("billingAddressStreet", billingAddressStreet);		
//				&billingAddressNumber=1384\
//form.param("billingAddressNumber", billingAddressNumber);		
//				&billingAddressComplement=5o andar\
//form.param("billingAddressComplement", billingAddressComplement);		
//				&billingAddressDistrict=Jardim Paulistano\
//form.param("billingAddressDistrict", billingAddressDistrict);
//				&billingAddressPostalCode=01452002\
//form.param("billingAddressPostalCode", billingAddressPostalCode);		
//				&billingAddressCity=Sao Paulo\
//form.param("billingAddressCity", billingAddressCity);		
//				&billingAddressState=SP\
//form.param("billingAddressState", billingAddressState);		
//				&billingAddressCountry=BRA\"	
//form.param("billingAddressCountry", billingAddressCountry);		
		//target.property(ClientProperties, value)
		MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
		String xml = "";
		for (Map.Entry<String, List<String>> queryEntry : queryParams.entrySet()) {
			
			String key = queryEntry.getKey();
			String val = queryEntry.getValue().get(0);
			System.out.println("key=" + key);
			System.out.println("val=" + val);
            + "<cliente>" 
            + "<nome>Organisys Software</nome>"
            + "<tipoPessoa>J</tipoPessoa>"
            + "<endereco>Rua Visconde de São Gabriel</endereco>"
            + "<cpf_cnpj>00000000000000</cpf_cnpj>"
            + "<ie_rg>3067663000</ie_rg>"
            + "<numero>392</numero>"
            + "<complemento>Sala 54</complemento>"
            + "<bairro>Cidade Alta</bairro>"
            + "<cep>95.700-000</cep>"
            + "<cidade>Bento Gonçalves</cidade>"
            + "<uf>RS</uf>"
            + "<fone>5481153376</fone>"
            + "<email>teste@teste.com.br</email>"
            + "</cliente>"
            
            
            + "<transporte>"
            + "<transportadora>Transportadora XYZ</transportadora>"
            + "<tipo_frete>R</tipo_frete>"
            + "<servico_correios>SEDEX - CONTRATO</servico_correios>"
            + "<dados_etiqueta>"
            + "<nome>Endereço de entrega</nome>"
            + "<endereco>Rua Visconde de São Gabriel</endereco>"
            + "<numero>392</numero>"
            + "<complemento>Sala 59</complemento>"
            + "<municipio>Bento Gonçalves</municipio>"
            + "<uf>RS</uf>"
            + "<cep>95.700-000</cep>"
            + "<bairro>Cidade Alta</bairro>"
            + "</dados_etiqueta>"
            + "<volumes>"
            + "<volume>"
            + "<servico>SEDEX - CONTRATO</servico>"
            + "<codigoRastreamento></codigoRastreamento>"
            + "</volume>"
            + "<volume>"
            + "<servico>PAC - CONTRATO</servico>"
            + "<codigoRastreamento></codigoRastreamento>"
            + "</volume>"
            + "</volumes>"
            + "</transporte>"
            
            + "<itens>"
            + "<item>"
            + "<codigo>001</codigo>"
            + "<descricao>Caneta 001</descricao>"
            + "<un>Pç</un>"
            + "<qtde>10</qtde>"
            + "<vlr_unit>1.68</vlr_unit>"
            + "</item>"
            + "<item>"
            + "<codigo>002</codigo>"
            + "<descricao>Caderno 002</descricao>"
            + "<un>Un</un>"
            + "<qtde>3</qtde>"
            + "<vlr_unit>3.75</vlr_unit>"
            + "</item>"
            + "<item>"
            + "<codigo>003</codigo>"
            + "<descricao>Teclado 003</descricao>"
            + "<un>Cx</un>"
            + "<qtde>7</qtde>"
            + "<vlr_unit>18.65</vlr_unit>"
            + "</item>"
            + "</itens>"
            
            + "<parcelas>"
            + "<parcela>"
            + "<data>01/09/2009</data>"
            + "<vlr>100</vlr>"
            + "<obs>Teste obs 1</obs>"
            + "</parcela>"
            + "<parcela>"
            + "<data>06/09/2009</data>"
            + "<vlr>50</vlr>"
            + "<obs></obs>"
            + "</parcela>"
            + "<parcela>"
            + "<data>11/09/2009</data>"
            + "<vlr>50</vlr>"
            + "<obs>Teste obs 3</obs>"
            + "</parcela>"
            + "</parcelas>"
            
            
            + "<vlr_frete>15</vlr_frete>"
            
            + "<vlr_desconto>10</vlr_desconto>"
            
            + "<obs>Testando o campo observações do pedido</obs>"
            
            + "<obs_internas>Testando o campo observações internas do pedido</obs_internas>"
		
  	        xml = "<?xml version='1.0' encoding='iso8859-1'?>" 
	    		+ "<pedido>" 
                + "<cliente>" 
                + "<nome>Organisys Software</nome>"
                + "<tipoPessoa>J</tipoPessoa>"
                + "<endereco>Rua Visconde de São Gabriel</endereco>"
                + "<cpf_cnpj>00000000000000</cpf_cnpj>"
                + "<ie_rg>3067663000</ie_rg>"
                + "<numero>392</numero>"
                + "<complemento>Sala 54</complemento>"
                + "<bairro>Cidade Alta</bairro>"
                + "<cep>95.700-000</cep>"
                + "<cidade>Bento Gonçalves</cidade>"
                + "<uf>RS</uf>"
                + "<fone>5481153376</fone>"
                + "<email>teste@teste.com.br</email>"
                + "</cliente>"
                + "<transporte>"
                + "<transportadora>Transportadora XYZ</transportadora>"
                + "<tipo_frete>R</tipo_frete>"
                + "<servico_correios>SEDEX - CONTRATO</servico_correios>"
                + "<dados_etiqueta>"
                + "<nome>Endereço de entrega</nome>"
                + "<endereco>Rua Visconde de São Gabriel</endereco>"
                + "<numero>392</numero>"
                + "<complemento>Sala 59</complemento>"
                + "<municipio>Bento Gonçalves</municipio>"
                + "<uf>RS</uf>"
                + "<cep>95.700-000</cep>"
                + "<bairro>Cidade Alta</bairro>"
                + "</dados_etiqueta>"
                + "<volumes>"
                + "<volume>"
                + "<servico>SEDEX - CONTRATO</servico>"
                + "<codigoRastreamento></codigoRastreamento>"
                + "</volume>"
                + "<volume>"
                + "<servico>PAC - CONTRATO</servico>"
                + "<codigoRastreamento></codigoRastreamento>"
                + "</volume>"
                + "</volumes>"
                + "</transporte>"
                + "<itens>"
                + "<item>"
                + "<codigo>001</codigo>"
                + "<descricao>Caneta 001</descricao>"
                + "<un>Pç</un>"
                + "<qtde>10</qtde>"
                + "<vlr_unit>1.68</vlr_unit>"
                + "</item>"
                + "<item>"
                + "<codigo>002</codigo>"
                + "<descricao>Caderno 002</descricao>"
                + "<un>Un</un>"
                + "<qtde>3</qtde>"
                + "<vlr_unit>3.75</vlr_unit>"
                + "</item>"
                + "<item>"
                + "<codigo>003</codigo>"
                + "<descricao>Teclado 003</descricao>"
                + "<un>Cx</un>"
                + "<qtde>7</qtde>"
                + "<vlr_unit>18.65</vlr_unit>"
                + "</item>"
                + "</itens>"
                + "<parcelas>"
                + "<parcela>"
                + "<data>01/09/2009</data>"
                + "<vlr>100</vlr>"
                + "<obs>Teste obs 1</obs>"
                + "</parcela>"
                + "<parcela>"
                + "<data>06/09/2009</data>"
                + "<vlr>50</vlr>"
                + "<obs></obs>"
                + "</parcela>"
                + "<parcela>"
                + "<data>11/09/2009</data>"
                + "<vlr>50</vlr>"
                + "<obs>Teste obs 3</obs>"
                + "</parcela>"
                + "</parcelas>"
                + "<vlr_frete>15</vlr_frete>"
                + "<vlr_desconto>10</vlr_desconto>"
                + "<obs>Testando o campo observações do pedido</obs>"
                + "<obs_internas>Testando o campo observações internas do pedido</obs_internas>"
                + "</pedido>";
		}    
		//Response response = target.request().post(Entity.xml(xml));
		//Response response = target.request().post(Entity.entity(form,  MediaType.APPLICATION_FORM_URLENCODED_TYPE + ";charset=utf-8"));
	    //Response response = target.queryParam(name, values) request().post(Entity.entity(xml3,  MediaType.APPLICATION_FORM_URLENCODED_TYPE + ";charset=iso8859-1"));
	    
	    
	    Client client = ClientBuilder.newClient();
	    WebTarget target = client.target("https://bling.com.br/Api/v2/pedido/json");
	    Form form = new Form();
	    form.param("apikey", "bd7e67a5cc06e91702f7309cc696184e521b0c6a607e1129f3750ceeb8f17ae135c3166c");
	    form.param("xml", xml);
//temp	    String responseResult = target.request(MediaType.APPLICATION_XML_TYPE).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);	    
	    
		//if(response.getStatus() == Status.CREATED.getStatusCode()){
		//	System.out.println("FOI CRIAADA A SESSAO");
		//}
		
		//Fruta fruta = response.readEntity(Fruta.class);
		//Sessao sessao = response.readEntity(Sessao.class);
		//String idSessaoStr = sessao.getId().toString();
		//response.close();
		//String output = response.readEntity(String.class);
//temp		System.out.println("postOrderServiceBling =" + responseResult);  //idSessaoStr);
		//gravaIdSessao(idSessaoStr);
		//String output = response.readEntity(String.class);
//temp		return responseResult;
	    return "";
	}*/	
	
}
