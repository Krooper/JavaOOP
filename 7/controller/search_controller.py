from model.Search_model import Search


class Search_Controller:
    __shop_for_search = None
    __initial_user = None

    def __init__(self, shop, user):
        self.__shop_for_search = shop
        self.__initial_user = user

    def get_shop(self):
        return self.__shop_for_search

    def set_shop(self, shop):
        self.__shop_for_search = shop

    def get_user(self):
        return self.__initial_user

    def set_user(self, user):
        self.__initial_user = user

    def new_search(self):
        self.__initial_user.set_requested_criteria()
        self.__initial_user.print_criteria()

        self.__initial_user.set_requested_chars()
        filter_dict = self.__initial_user.get_requested_chars()

        self.__shop_for_search.set_request(filter_dict)
        print(self.__shop_for_search.get_request())

        user_filter = Search(self.__shop_for_search.get_request())
        self.__initial_user.set_filter(user_filter)
