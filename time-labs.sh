#!/bin/bash

export sum=0
grep -e '"timer"' devoxx-2018.slides.html  | sed -e 's;<div class="timer">;;' -e "s;'.*$;;" | while read t ;
do
    sum=$(expr ${sum} + ${t}) ;
    echo $sum
done | tail -1
