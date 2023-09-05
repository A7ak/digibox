package com.example.myapplication

import android.content.Context

typealias intLambda= (Any) -> Unit
class LiveData(var context: Context) {

    var state = arrayOf("active", "inactive")
    var currentValue : Int? = null
    var currentState = state[0]

    /*fun observe(changeValue: Int, current: Int?): Int? {
        currentValue = current
        return when (currentState) {
            state[0] -> {
                if (currentValue != changeValue) {
                    current
                } else {
                    null
                }
            }

            state[1] -> {
                null
            }

            else -> {
                null
            }
        }

    }
*/

    fun observe(
        value : Int,
        changedValue: intLambda
    ) {
        currentState = state[0]
        currentValue = value
        changedValue(0)
    }

    fun setData(value : Int) {
        if(currentValue != value) {
        callOberser(value)
            currentValue = value
         } else { value}
    }

    private fun callOberser(value: Int) {
        (context as MainActivity).value = value
        (context as MainActivity).observeData()

    }

    fun removeObserver() {
        currentState = state[1]
    }
}