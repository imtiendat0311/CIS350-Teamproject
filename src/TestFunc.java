// import java.io.IOException;
// import java.net.HttpURLConnection;
// import java.net.MalformedURLException;
// import java.net.URL;
// import java.util.Scanner;
// import org.apache.commons.text.*;
// import org.json.*;

// public class Main {
// public static void main(String[] args) {
// try {
// String inline = "";
// URL url = new URL("https://opentdb.com/api.php?amount=20&type=multiple&");
// HttpURLConnection con = (HttpURLConnection) url.openConnection();
// con.setRequestMethod("GET");
// con.connect();
// Scanner scan = new Scanner(url.openStream());
// while (scan.hasNext()) {
// inline += scan.nextLine();
// }
// scan.close();

// JSONObject obj = new JSONObject(inline);
// JSONArray arr = obj.getJSONArray("results");
// for (int i = 0; i < arr.length(); i++) {
// String question = arr.getJSONObject(i).getString("question").toString();
// String correctAns =
// arr.getJSONObject(i).getString("correct_answer").toString();
// JSONArray choice = arr.getJSONObject(i).getJSONArray("incorrect_answers");
// System.out.println(StringEscapeUtils.unescapeHtml4(question));
// for (int j = 0; j < choice.length(); j++) {
// System.out.print(j + " " +
// StringEscapeUtils.unescapeHtml4(choice.getString(j) + " "));
// }
// System.out.println("Correct: " +
// StringEscapeUtils.unescapeHtml4(correctAns));
// }
// } catch (MalformedURLException e) {

// e.printStackTrace();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
// }
