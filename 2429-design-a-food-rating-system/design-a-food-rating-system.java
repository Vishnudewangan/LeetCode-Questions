
class FoodRatings {
     static class Pair implements Comparable<Pair>
     {
          int rating;
          String food;

          Pair(int rating , String food)
          {
              this.rating = rating;
              this.food = food;
          }

          public int compareTo(Pair o)
          {
              if(this.rating == o.rating)
              {
                     return stringCompare(this.food, o.food);
              }
              else
              {
                  return Integer.compare(o.rating , this.rating);
              }
          }

          static int stringCompare(String str1 , String str2)
          {
              int i=0, j=0;

              while(i<str1.length() && j<str2.length())
              {  
                  char ch1 = str1.charAt(i);
                  char ch2 = str2.charAt(j);
                  if(ch1==ch2)
                  {   i++;
                      j++;
                      continue;
                  }
                  else if(ch1!=ch2)
                  {      
                      return Integer.compare(ch1,ch2);
                  }
                 else {
                     i++;
                     j++;
                 }
                 
              }
              return Integer.compare(str1.length(),str2.length());
          }
    }

     HashMap<String,String> fdCntry;/// food v/s country
     HashMap<String,TreeSet<Pair>> cntryRtng; /// country v/s TreeSet<Pair> 
                                              /// pair will contain 1) rating 2) food
    HashMap<String,Integer> fdRating;/// food v/s rating
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
         fdCntry =new HashMap<>();
         cntryRtng= new HashMap<>();
         fdRating = new HashMap<>();
        for(int i=0;i<foods.length;i++)
        {
            fdCntry.put(foods[i],cuisines[i]);
            fdRating.put(foods[i],ratings[i]);
            Pair p =new Pair(ratings[i],foods[i]);
            
            TreeSet<Pair> ts=  cntryRtng.getOrDefault(cuisines[i],new TreeSet<Pair>());
              ts.add(p);
              cntryRtng.put(cuisines[i],ts);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cntry = fdCntry.get(food);

         TreeSet<Pair> ts=  cntryRtng.get(cntry);
         Pair oldPair = new Pair(fdRating.get(food),food);/// creating old Pair to remove from ts
         ts.remove(oldPair);
         Pair newPair =new Pair(newRating,food);/// creating new Pair to add to ts
         ts.add(newPair);
         fdRating.put(food,newRating);/// replacing old food rating from fdRating map
    }
    
    public String highestRated(String cuisine) {
        return cntryRtng.get(cuisine).first().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */