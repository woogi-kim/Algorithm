import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int x1,y1,r1,x2,y2,r2;
		double d;
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			x1=Integer.parseInt(st.nextToken());
			y1=Integer.parseInt(st.nextToken());
			r1=Integer.parseInt(st.nextToken());
			x2=Integer.parseInt(st.nextToken());
			y2=Integer.parseInt(st.nextToken());
			r2=Integer.parseInt(st.nextToken());
			
			d=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
			
			if(x1==x2 && y1==y2) {
				if(r1==r2)
					sb.append(-1+"\n");
				else
					sb.append(0+"\n");
			}
			else {
				if(r1+r2 < d || (r1-r2)*(r1-r2)>d*d)
					sb.append(0+"\n");
				else if(r1+r2==d || (r1-r2)*(r1-r2)==d*d)
					sb.append(1+"\n");
				else if((r1-r2)*(r1-r2)<d*d && d*d<(r1+r2)*(r1+r2))
					sb.append(2+"\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}