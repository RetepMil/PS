class Solution {

    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val wantMap = hashMapOf<String, Int>()
        for (i in want.indices) {
            val item = want[i]
            val freq = number[i]
            wantMap[item] = freq
        }

        var answer = 0
        val currentMap = hashMapOf<String, Int>()
        for (i in discount.indices) {
            val item = discount[i]

            if (currentMap[item] == null && wantMap[item] != null)
                currentMap[item] = 0

            if (i < 10) {
                wantMap[item] ?: continue
                currentMap[item] = currentMap[item]!! + 1
            }

            if (i >= 10) {
                val exited = discount[i - 10]
                val entered = item

                if (wantMap[exited] != null && currentMap[exited]!! != 0)
                    currentMap[exited] = currentMap[exited]!! - 1

                if (wantMap[entered] != null)
                    currentMap[entered] = currentMap[entered]!! + 1
            }

            if (currentMap == wantMap) answer++
        }

        return answer
    }
}
