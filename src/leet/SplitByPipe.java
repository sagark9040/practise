package leet;

public class SplitByPipe {
	public static void main(String args[]) {
		
		String s = "https://www.jcrew.com/p/womens_category/pants2/relaxedcrop/seaside-pant-in-cotton-twill/H7729|H7729|99104898158|Dark Ink|BL9371|2|2|Seaside pant in cotton twill|88.00|Our best-selling seaside pant, now in 100 percent cotton so it's weighty enough for between-seasons weather. Sits at hip.Easy through hip and thigh, with a straight leg.Front rise: 10 3/4&#34;; 25 1/2&#34; inseam; 12&#34; leg opening.Cotton.Drawstring at waist.Pockets.Machine wash.Import.|J.Crew|https://www.jcrew.com/s7-img-facade/H7729_BL9371_m?$pdp_fs418_3x_zoom$|88.00|1689949373910615|375|0|https://www.jcrew.com/s7-img-facade/H7729_BL9371?$pdp_fs418_3x_zoom$|H7729BL93712";
		String res[] = s.split("\\|");
			
		System.out.println(res.length);
		System.out.println("-------------------");
		for(String r : res)
			System.out.println(r);
	}
}
