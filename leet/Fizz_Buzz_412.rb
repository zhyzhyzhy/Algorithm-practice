# @param {Integer} n
# @return {String[]}
def fizz_buzz(n)
    i = 1
    temp = []
    while i<=n do
        if i%3 ==0 && i%5 == 0
            temp.push("FizzBuzz")
            i = i + 1
            next
        end
        if i%3 == 0
            temp.push("Fizz")
            i = i + 1
            next
        end
        if i%5 == 0
            temp.push("Buzz")
            i = i + 1
            next
        end
        temp.push(i.to_s)
        i = i + 1
    end
    temp
end

print fizz_buzz(0)
