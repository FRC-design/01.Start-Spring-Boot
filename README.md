
This is a learning material for myself.

// 微信抢红包


   private static final float MIN_COUNT = 0.01f;
 
   public List<Float> func(float total, int k) {
    List<Float> res = new ArrayList<>(k);
    if (total <= 0 || k <= 0 || k * MIN_COUNT > total){
      return res;
 } 
 
    Random random = new Random();
    while (k != 0) {
        if (k == 1) {
            res.add(total);
        } else {
            float cur = MIN_COUNT + random.nextFloat(total - k * MIN_COUNT);
            res.add(cur);
            total -= cur;
        }
        k--;
    }
 
    return res;
