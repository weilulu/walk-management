#!/usr/bin/env python
#-*- encoding:utf-8 -*-

import sys
import codecs
from textrank4zh import TextRank4Keyword,TextRank4Sentence

def getSummary(content):
    text = codecs.encode(content,'gbk')
    tr4w = TextRank4Sentence(stop_words_file = './stopwords.data')    
    tr4s.analyze(text,lower=True)
    s_list = tr4s.get_key_sentences(num=1,sentence_min_len = 5)
    print 'Summary:'
    print
    for s in s_list:
        print s.sentence,s.weight
    print
    return s_list
