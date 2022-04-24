package com.gmail.evanloafakahaitao.hwk.hwk19.task3;


public class ListFactory {

    private ListFactory() {}

    public static class Holder {
        public static ListFactory listFactory = new ListFactory();
    }

    public static ListFactory getInstance() {
        return Holder.listFactory;
    }

    public void getList(ListType listType) {
        switch (listType) {
            case ARRAY_LIST: {
                ListService listService = new ArrayListServiceImpl();
                System.out.println(listService.generateList());
                break;
            }
            case LINKED_LIST: {
                ListService listService = new LinkedListServiceImpl();
                System.out.println(listService.generateList());
                break;
            }
                default: {
                    ListService listService = new ArrayListServiceImpl();
                    System.out.println(listService.generateList());
                    break;
                }
        }
    }

    public enum ListType {
        ARRAY_LIST,
        LINKED_LIST
    }
}
