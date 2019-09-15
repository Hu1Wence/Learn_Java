public class HNT {
	public static void main(String[] args) {
		hnts("a","b","c",2);
	}
	
	public static void hnts(String from,String temp,String to,int n){
		if(n==1){
			System.out.println(from+"------>"+to);
		}else{
			hnts(from,to,temp,n-1);
			hnts(from,temp,to,1);
			hnts(temp,from,to,n-1);
		}
		
	}
}

