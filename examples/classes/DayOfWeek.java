public class DayOfWeek {
      public void printTheSeason(int month) {
        var result = switch(month) {
          case 1, 2, 3 -> "Winter";
          case 4, 5, 6 -> "Spring";
          case 7, 8, 9 -> "Summer";
          case 10, 11, 12 -> "Fall";
	  default -> "Invalid value";
        };

        System.out.println(result);
      }

      public void printDayOfWeek(int day) {
        var result = switch(day) {
          case 0 -> "Sunday";
          case 1 -> "Monday";
          case 2 -> "Tuesday";
          case 3 -> "Wednesday";
          case 4 -> "Thursday";
          case 5 -> "Friday";
          case 6 -> "Saturday";
          default -> "Invalid value";
        };

        System.out.println(result);
      }

      public static void main(String[] args) {
        var dayOfWeek = new DayOfWeek();
	dayOfWeek.printDayOfWeek(0);
        dayOfWeek.printDayOfWeek(3);
        dayOfWeek.printDayOfWeek(5);
        dayOfWeek.printDayOfWeek(1);

	dayOfWeek.printTheSeason(1);
	dayOfWeek.printTheSeason(6);
      }
}

