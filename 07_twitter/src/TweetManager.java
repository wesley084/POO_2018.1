public class TweetManager {
	private static int nextTweetId;
	
	public TweetManager() {
		nextTweetId = 0;
	}
	
	static String gerarTweetId() {
		nextTweetId++;
		return (nextTweetId-1)+"";
	}
}
