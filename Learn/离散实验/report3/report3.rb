class Pair
	attr_accessor :former, :after 
end

class Judge
	attr_accessor :elementTotal, :pairsTotal, :pairs, :matrix

	public

	def initialize
 		pairsTotal = 0
		pairs = []
    matrix = []
	end

 	def getElement
 		p "input the dense you want "
 		elementTotal = gets
 		matrix = Array.new(elementTotal)
    (0...elementTotal).each do |i|
      matrix[i] = Array.new(elementTotal)
    end
  end

  def getPairs
    p "input the pairs"
    loop do
      pairs[pairsTotal].former = gets
      pairs[pairsTotal].after = gets
    end
  end
end

demo = Judge.new
demo.getElement
demo.getPairs