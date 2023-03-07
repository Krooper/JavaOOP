class Notebook:
    __id = None
    __brand = ''
    __ram = 0
    __rom = 0
    __proc = ''
    __screen_diag = 0.0
    __os = ''
    __colour = ''
    __price = 0
    __in_stock = False
    criteria_dict = {}
    characteristics_dict = {}

    def get_brand(self):
        return self.__brand
    def set_brand(self, brand):
        self.__brand = brand

    def get_ram(self):
        return self.__ram
    def set_ram(self, ram):
        self.__ram = ram

    def get_rom(self):
        return self.__rom
    def set_rom(self, rom):
        self.__rom = rom

    def get_proc(self):
        return self.__proc
    def set_proc(self, proc):
        self.__proc = proc

    def get_screen_diag(self):
        return self.__screen_diag
    def set_screen_diag(self, screen_diag):
        self.__screen_diag = screen_diag

    def get_os(self):
        return self.__os
    def set_os(self, os):
        self.__os = os

    def get_colour(self):
        return self.__colour
    def set_colour(self, colour):
        self.__colour = colour

    def get_price(self):
        return self.__price
    def set_price(self, price):
        self.__price = price

    def get_in_stock(self):
        return self.__in_stock
    def set_in_stock(self, in_stock):
        self.__in_stock = in_stock

    @staticmethod
    def get_criteria_dict():
        return Notebook.criteria_dict

    @staticmethod
    def set_criteria_dict():
        criteria_dict = {}
        for i in range(len(Char_source.criteria)):
            criteria_dict[i+1] = Char_source.criteria[i]
        Notebook.criteria_dict = criteria_dict.copy()

    @staticmethod
    def get_characteristics_dict():
        return Notebook.characteristics_dict

    @staticmethod
    def set_characteristics_dict():
        characteristics_dict = {}
        for crit_key in Notebook.criteria_dict.keys():
            match crit_key:
                case 1:
                    j = len(Char_source.brands)
                    while j > 0:
                        characteristics_dict[f'{crit_key}{j}'] = Char_source.brands[j-1]
                        j -= 1
                case 2:
                    j = len(Char_source.rams)
                    while j > 0:
                        characteristics_dict[f'{crit_key}{j}'] = Char_source.rams[j - 1]
                        j -= 1
                case 3:
                    j = len(Char_source.roms)
                    while j > 0:
                        characteristics_dict[f'{crit_key}{j}'] = Char_source.roms[j - 1]
                        j -= 1
                case 4:
                    j = len(Char_source.procs)
                    while j > 0:
                        characteristics_dict[f'{crit_key}{j}'] = Char_source.procs[j - 1]
                        j -= 1
                case 5:
                    j = len(Char_source.screenDiags)
                    while j > 0:
                        characteristics_dict[f'{crit_key}{j}'] = Char_source.screenDiags[j - 1]
                        j -= 1
                case 6:
                    j = len(Char_source.oss)
                    while j > 0:
                        characteristics_dict[f'{crit_key}{j}'] = Char_source.oss[j - 1]
                        j -= 1
                case 7:
                    j = len(Char_source.colours)
                    while j > 0:
                        characteristics_dict[f'{crit_key}{j}'] = Char_source.colours[j - 1]
                        j -= 1
                case 9:
                    j = len(Char_source.in_stocks)
                    while j > 0:
                        characteristics_dict[f'{crit_key}{j}'] = Char_source.in_stocks[j - 1]
                        j -= 1
        Notebook.characteristics_dict = characteristics_dict.copy()

    def __init__(self, id, brand, ram, rom, proc, screen_diag, os, colour, in_stock, price):
        self.__id = id
        self.__brand = brand
        self.__ram = ram
        self.__rom = rom
        self.__proc = proc
        self.__screen_diag = screen_diag
        self.__os = os
        self.__colour = colour
        self.__price = price
        self.__in_stock = in_stock

    def __str__(self):
        return f"Notebook {self.__id} :\n" \
               f"\tBrand: {self.__brand}\n" \
               f"\tRAM: {self.__ram} Gb\n" \
               f"\tROM: {self.__rom} Gb\n" \
               f"\tProcessor Brand: {self.__proc}\n" \
               f"\tScreen Diagonal: {self.__screen_diag}\"\n" \
               f"\tOperating System: {self.__os}\n" \
               f"\tColour: {self.__colour}\n" \
               f"\tPrice: {self.__price}\n" \
               f"\tIn Stock: {self.__in_stock}\n"
    