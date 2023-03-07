from service.User_service import User_Service


class User_Controller:

    __service = User_Service()

    @staticmethod
    def save_user(user, users):
        User_Controller.__service.save_user(user, users)
