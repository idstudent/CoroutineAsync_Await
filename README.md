# 코루틴 launch, async
  * launch 결과를 반환하지 않고, launch 실행시 Job 반환
  * async 결과를 반환, Deffered로 반환하며, Deffered는 미래에 올 수 있는 값을 담아놓은 객체임 
  
# 코루틴 await 
  * async의 코루틴이 끝날때까지, 기다리고 결과 리턴

 ```
        CoroutineScope(Main).launch { // ui 작업을 위해 Main

            val result1 = async(IO) {
                getResult1() // 값 반환
            }

            val result2 = async(IO) {
                getResult2() // 값 반환
            }

            val total = result1.await() + result2.await()

            resultView.text = total.toString()
        }
        
        private suspend fun getResult1() : Int {
            delay(10000)
            Log.e("ljy", "getResult1 호출")
            return 100
        }

        private suspend fun getResult2() : Int {
            delay(5000)
            Log.e("ljy", "getResult2 호출")
            return 200
        }
```
# 결과
 * getReuslt2가 getResult1보다 딜레이가 적기 때문에, getResult2 로그가 먼저 찍히고, 그다음 getResult1 로그가 찍힘
   await으로 기다림으로, 결과는 getResult의 딜레이 10초동안 기다리고, textview에 계산된 값을 뿌려줌
