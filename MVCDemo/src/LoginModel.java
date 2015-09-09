
public class LoginModel {
	

	public boolean isUserExist(String userid , String password){
		if(userid.equals(password)){
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
