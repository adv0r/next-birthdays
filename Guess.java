import javax.swing.JOptionPane;

public class Guess
{
  public static int[] FIRST_DAYS_1900 = new int[12];
  public static int myBirthDay;
  public static int myBirthMonth;
  public static int yearGuess;
  public static boolean another;

  public static void main(String[] args)
  {
    fillDays1900();
    getMyBirthDay();
    do {
      another = getYearGuess();
      String estimate = guess(yearGuess);
      String message = "In " + yearGuess + " your birthday will be on " + estimate;
      JOptionPane.showMessageDialog(null, message);
    }
    while (
      another);
    System.exit(0);
  }

  public static String guess(int yearGuess)
  {
    String toReturn = "";
    int distanceFrom1900 = yearGuess - 1900;
    int firstDayOfTheMonthIn1900 = FIRST_DAYS_1900[(myBirthMonth - 1)];
    int numberOfBisestile = distanceFrom1900 / 4;
    int sum = distanceFrom1900 + firstDayOfTheMonthIn1900 + numberOfBisestile + myBirthDay - 1;
    int rest = sum % 7;
    if ((isBisestile(yearGuess)) && ((myBirthMonth == 1) || (myBirthMonth == 2))) {
      rest--;
    }
    toReturn = getDayName(rest);
    return toReturn;
  }

  public static boolean isBisestile(int y)
  {
    boolean toReturn = false;
    if (y % 4 == 0)
    {
      if (y % 100 == 0) {
        if (y % 400 == 0) {
          toReturn = true;
        }
      }
      else {
        toReturn = true;
      }

    }

    return toReturn;
  }

  public static boolean getYearGuess() {
    boolean toReturn = false;
    String toParse = JOptionPane.showInputDialog("Insert the year you wish to know the day of the week your birthday will be (yyyy) . Type -1 to quit");
    if (!toParse.equals("-1"))
    {
      yearGuess = Integer.parseInt(toParse);
      if ((yearGuess > 1900) && (yearGuess < 9999))
        toReturn = true;
    }
    else
    {
      System.exit(0);
    }
    return toReturn;
  }

  public static void getMyBirthDay()
  {
    String toParse = JOptionPane.showInputDialog("Insert your birth day ( dd-mm )");
    myBirthDay = Integer.parseInt(toParse.substring(0, toParse.indexOf("-")));
    myBirthMonth = Integer.parseInt(toParse.substring(toParse.indexOf("-") + 1, toParse.length()));
  }

  public static void fillDays1900()
  {
    FIRST_DAYS_1900[0] = 1;
    FIRST_DAYS_1900[1] = 4;
    FIRST_DAYS_1900[2] = 4;
    FIRST_DAYS_1900[3] = 0;
    FIRST_DAYS_1900[4] = 2;
    FIRST_DAYS_1900[5] = 5;
    FIRST_DAYS_1900[6] = 0;
    FIRST_DAYS_1900[7] = 3;
    FIRST_DAYS_1900[8] = 6;
    FIRST_DAYS_1900[9] = 1;
    FIRST_DAYS_1900[10] = 4;
    FIRST_DAYS_1900[11] = 6;
  }

  public static String getDayName(int code)
  {
    String toReturn = "";
    switch (code) { case 0:
      toReturn = "Sunday"; break;
    case 1:
      toReturn = "Monday"; break;
    case 2:
      toReturn = "Tuesday"; break;
    case 3:
      toReturn = "Wednesday"; break;
    case 4:
      toReturn = "Thursday"; break;
    case 5:
      toReturn = "Friday"; break;
    case 6:
      toReturn = "Saturday"; break;
    }

    return toReturn;
  }
}