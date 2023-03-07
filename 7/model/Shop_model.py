class Shop:
    __notebooks = None
    __request = None

    def __init__(self, name):
        self.__name = name

    def get_name(self):
        return self.__name
    def set_name(self, name):
        self.__name = name

    @staticmethod
    def get_notebooks():
        return Shop.__notebooks

    def set_notebooks(self, notebooks):
        self.__notebooks = notebooks

    def set_request(self, filter):
        new_request = Search_service()
        new_request.set_user_request(filter)

        if len(new_request.get_brands()) == 0:
            new_request.set_brands()
        if len(new_request.get_rams()) == 0:
            new_request.set_rams()
        if len(new_request.get_roms()) == 0:
            new_request.set_roms()
        if len(new_request.get_screens()) == 0:
            new_request.set_screens()
        if len(new_request.get_procs()) == 0:
            new_request.set_procs()
        if len(new_request.get_oss()) == 0:
            new_request.set_oss()
        if len(new_request.get_colours()) == 0:
            new_request.set_colours()
        if len(new_request.get_in_stocks()) == 0:
            new_request.set_in_stocks()
        self.__request = new_request

    def get_request(self):
        return self.__request

    def __str__(self):
        out_str = ''
        for note in self.__notebooks:
            out_str += str(note)
        return out_str
