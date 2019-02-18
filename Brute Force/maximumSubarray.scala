/*

@readCase "print and println are used to customize the output screen"

*/
object maximumSubarray extends App {
  def maxSubArray(array: Array[Int]) = {
    var sum, maxSum, startIndex, endIndex, maxStartIndexUntilNow = 0
    for (idx <- array.indices) {
      sum += array(idx)
      if (array(idx) > sum) {
        sum = array(idx)
        startIndex = idx
      }
      if (sum > maxSum) {
        maxSum = sum
        startIndex = maxStartIndexUntilNow
        endIndex = idx
      } else if (sum < 0) {
        maxStartIndexUntilNow = idx + 1
        sum = 0
      }
    }
    (maxSum,startIndex,endIndex)
  }

  println(maxSubArray(Array(3, -1, -1, -1, -1, -1, 2, 0, 0, 0)))
  //(3,0,0)

  println(maxSubArray(Array(-1, 3, -5, 4, 6, -1, 2, -7, 13, -3)))
  //(17,3,8)

  println(maxSubArray(Array(-6,-2,-3,-4,-1,-5,-5)))
  //(0,0,0)
}
