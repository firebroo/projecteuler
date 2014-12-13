import itertools
import time
#@S 大神的解法，只要0.5sec，膜拜
def conquer():
    ans = 0
    DIGIT_LIMIT = 7
    ITER_STR = "0123456789"
    sum_square = lambda ss: sum( int( s ) ** 2 for s in str( ss ) )
    fact = lambda num: reduce( lambda x, y: x * y, xrange( 1, num + 1 ) )
    combinations = itertools.combinations_with_replacement( ITER_STR,
                                                            DIGIT_LIMIT )
    
    def combinatorial_num( num ):
        res = fact( DIGIT_LIMIT )
        s = str( num )
        for ss in ITER_STR:
            count = s.count( ss )
            if count > 1: res /= fact( count )
        return res
    
    for c in combinations:
        num = int( "".join( c ) )
        print num
        if num == 0: continue
        while num != 89 and num != 1:
            num = sum_square( num )
        if num == 89:
            ans += combinatorial_num( c )

    print ans

begin = time.time()
conquer()
end = time.time()
print end - begin
