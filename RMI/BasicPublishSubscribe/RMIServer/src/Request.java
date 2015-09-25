
public class Request {
	private int _number;
	private ClientInterface _client;
	
	public Request(int _number, ClientInterface _client){
		this._number=_number;
		this._client=_client;
		
	}
	
	
	
	public int get_number() {
		return _number;
	}



	public void set_number(int _number) {
		this._number = _number;
	}



	public ClientInterface get_client() {
		return _client;
	}
	public void set_client(ClientInterface _client) {
		this._client = _client;
	}
	
	
}
